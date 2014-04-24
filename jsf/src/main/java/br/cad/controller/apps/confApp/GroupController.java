package br.cad.controller.apps.confApp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.DualListModel;
import org.primefaces.model.TreeNode;

import br.cad.controller.AbstractCrudController;
import br.cad.model.system.Action;
import br.cad.model.system.Domain;
import br.cad.model.system.Group;
import br.cad.model.system.Permission;
import br.cad.model.system.Resource;
import br.cad.model.system.User;
import br.cad.service.system.ActionService;
import br.cad.service.system.DomainService;
import br.cad.service.system.GroupService;
import br.cad.service.system.ResourceService;
import br.cad.service.system.UserService;
import br.cad.util.DualListModelDiff;
import br.cad.util.TreePermission;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

/**
 * 
 * @author WilliamRodrigues
 * 
 */
@ViewScoped
@ManagedBean(name = "groupController")
@URLMappings(mappings = { 
		@URLMapping(id = "group-new", pattern = "/confApp/group/new", viewId = "/apps/confApp/group/new.jsf"),
		@URLMapping(id = "group-list", pattern = "/confApp/group/list", viewId = "/apps/confApp/group/list.jsf"),
		@URLMapping(id = "group-view", pattern = "/confApp/group/view/#{id}", viewId = "/apps/confApp/group/view.jsf"),
		@URLMapping(id = "group-edit", pattern = "/confApp/group/edit/#{id}", viewId = "/apps/confApp/group/edit.jsf") })
public class GroupController extends AbstractCrudController<Group, GroupService> implements Serializable {
	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * *****************************************************************************************************************
	 * ************************************************** Atributos ****************************************************
	 * *****************************************************************************************************************
	 */

	@ManagedProperty("#{groupService}")
	private GroupService service;
	@ManagedProperty("#{resourceService}")
	private ResourceService resourceService;
	@ManagedProperty("#{userService}")
	private UserService userService;
	@ManagedProperty("#{domainService}")
	private DomainService domainService;
	@ManagedProperty("#{actionService}")
	private ActionService actionService;
	
	private TreeNode root;
	private TreeNode[] nosSelecionados;

	/*
	 * *****************************************************************************************************************
	 * ************************************************ Gets e Sets ****************************************************
	 * *****************************************************************************************************************
	 */
	
	@Override
	public void setService(GroupService service) {
		this.service = super.service = service;
	}

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = super.resourceService = resourceService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setDomainService(DomainService domainService) {
		this.domainService = super.domainService = domainService;
	}

	public void setActionService(ActionService actionService) {
		this.actionService = super.actionService = actionService;
	}

	public DualListModel<User> getUserGroup() {
		return new DualListModelDiff<User>(userService.findAll(), getModel().getUsers());
	}

	public void setUserGroup(DualListModel<User> users) {
		this.getModel().setUsers(users.getTarget());
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public TreeNode[] getNosSelecionados() {
		return nosSelecionados;
	}

	public void setNosSelecionados(TreeNode[] nosSelecionados) {
		this.nosSelecionados = nosSelecionados;
	}

	/*
	 * *****************************************************************************************************************
	 * ************************************************** Metodos ******************************************************
	 * *****************************************************************************************************************
	 */

	@PostConstruct
	public void init() {
		this.setColumnsTemplate("{name Nome}, {description Descrição}");

		this.load();
		
		this.loadingPermissions();
	}
	
	public void loadingPermissions() {
		root = new CheckboxTreeNode("Permission", null);
		
		if (getModel() != null) {
			for (Resource r : resourceService.findAllWithoutDomain()) {
				TreeNode tResource = new CheckboxTreeNode(new TreePermission(r.getName(), null, null), root);
				for (Action act : r.getActions()) {
					TreeNode rAction = new CheckboxTreeNode(new TreePermission(act.getName(), r.getId(), act.getId()), tResource);
					rAction.setSelected(checkPermission(r, act));
				}
			}
			
			for (Domain domain : domainService.findAll()) {
				TreeNode nDomain = new CheckboxTreeNode(new TreePermission(domain.getName(), null, null), root);
				
				for (Domain subDomain : domain.getSubDomains()) {
					TreeNode nSubDomain = new CheckboxTreeNode(new TreePermission(subDomain.getName(), null, null), nDomain);
					for (Resource resource : subDomain.getResources()) {
						TreeNode nsResource = new CheckboxTreeNode(new TreePermission(resource.getName(), null, null), nSubDomain);
						
						for (Action action : resource.getActions()) {
							TreeNode nsAction = new CheckboxTreeNode(new TreePermission(action.getName(), resource.getId(), action.getId()), nsResource);
							nsAction.setPartialSelected(checkPermission(resource, action));
						}
					}
				}
				
				for (Resource resource : domain.getResources()) {
					TreeNode nResource = new CheckboxTreeNode(new TreePermission(resource.getName(), null, null), nDomain);
					
					for (Action action : resource.getActions()) {
						TreeNode nAction = new CheckboxTreeNode(new TreePermission(action.getName(), resource.getId(), action.getId()), nResource);
						nAction.setSelected(checkPermission(resource, action));
					}
				}
			}
		}
	}
	
	public void addPermissions() {
		List<Permission> permissions = new ArrayList<Permission>();
		
		for (TreeNode no : nosSelecionados) {
			if (no.isLeaf()) {
				TreePermission tree = (TreePermission) no.getData();
				if (tree.getAction() != null && tree.getResource() != null){
					Permission permission = new Permission();
					permission.setAction(actionService.findById(tree.getAction()));
					permission.setResource(resourceService.findById(tree.getResource()));
						
					permissions.add(permission);
				}
			}
		}
		
		getModel().setPermissions(permissions);
	}
	
	public Boolean checkPermission(Resource resource, Action action) {
		for(Permission permission : getModel().getPermissions()) {
			if(permission.getResource().equals(resource) && permission.getAction().equals(action)){
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void save() {
		addPermissions();
		
		super.save();
	}
}
