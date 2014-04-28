INSERT INTO `Dominio` (`id`, `icone`, `name`, `orderObject`, `idDomain`)  VALUES (1,'icon-cogs','CAD - Admin',0,NULL);
INSERT INTO `Dominio` (`id`, `icone`, `name`, `orderObject`, `idDomain`)  VALUES (2,'icon-leaf','Acadêmico',1,NULL);
INSERT INTO `Dominio` (`id`, `icone`, `name`, `orderObject`, `idDomain`)  VALUES (3,'icon-group','Pessoas',2,NULL);


INSERT INTO `Recurso` (`id`, `controllerBean`, `icon`, `indexPage`, `locationOfFiles`, `name`, `objectClass`, `idDomain`) VALUES (1,'ActionController','imagens/action.ico','list','confApp/action/','Ação','Action',1);
INSERT INTO `Recurso` (`id`, `controllerBean`, `icon`, `indexPage`, `locationOfFiles`, `name`, `objectClass`, `idDomain`) VALUES (2,'DomainController','imagens/domain.ico','list','confApp/domain/','Domínio','Domain',1);
INSERT INTO `Recurso` (`id`, `controllerBean`, `icon`, `indexPage`, `locationOfFiles`, `name`, `objectClass`, `idDomain`) VALUES (3,'GroupController','imagens/group.ico','list','confApp/group/','Grupo','Group',1);
INSERT INTO `Recurso` (`id`, `controllerBean`, `icon`, `indexPage`, `locationOfFiles`, `name`, `objectClass`, `idDomain`) VALUES (4,'ResourceController','imagens/resource.ico','list','confApp/resource/','Recurso','Resource',1);
INSERT INTO `Recurso` (`id`, `controllerBean`, `icon`, `indexPage`, `locationOfFiles`, `name`, `objectClass`, `idDomain`) VALUES (5,'UserController','imagens/user.ico','list','confApp/user/','Usuário','User',1);
INSERT INTO `Recurso` (`id`, `controllerBean`, `icon`, `indexPage`, `locationOfFiles`, `name`, `objectClass`, `idDomain`) VALUES (6,'CursoController','imagens/books.ico','list','academico/curso/','Curso','Curso',2);
INSERT INTO `Recurso` (`id`, `controllerBean`, `icon`, `indexPage`, `locationOfFiles`, `name`, `objectClass`, `idDomain`) VALUES (7,'DisciplinaController','imagens/discipline.ico','list','academico/disciplina/','Disciplina','Disciplina',2);
INSERT INTO `Recurso` (`id`, `controllerBean`, `icon`, `indexPage`, `locationOfFiles`, `name`, `objectClass`, `idDomain`) VALUES (8,'TurmaController','imagens/team.ico','list','academico/turma/','Turma','Turma',2);
INSERT INTO `Recurso` (`id`, `controllerBean`, `icon`, `indexPage`, `locationOfFiles`, `name`, `objectClass`, `idDomain`) VALUES (9,'AdministradorController','imagens/admin-user.ico','list','pessoa/administrador/','Administrador','Administrador',3);
INSERT INTO `Recurso` (`id`, `controllerBean`, `icon`, `indexPage`, `locationOfFiles`, `name`, `objectClass`, `idDomain`) VALUES (10,'AlunoController','imagens/studant-user.ico','list','pessoa/aluno/','Aluno','Aluno',3);
INSERT INTO `Recurso` (`id`, `controllerBean`, `icon`, `indexPage`, `locationOfFiles`, `name`, `objectClass`, `idDomain`) VALUES (11,'DocenteController','imagens/teacher-user.ico','list','pessoa/docente/','Docente','Docente',3);
INSERT INTO `Recurso` (`id`, `controllerBean`, `icon`, `indexPage`, `locationOfFiles`, `name`, `objectClass`, `idDomain`) VALUES (12,'GradeController','imagens/info.ico','list','academico/grade/','Grade','Grade',2);
INSERT INTO `Recurso` (`id`, `controllerBean`, `icon`, `indexPage`, `locationOfFiles`, `name`, `objectClass`, `idDomain`) VALUES (13,'PlanoEstudoController','imagens/info.ico','list','academico/plano/','Plano de Estudo','PlanoEstudo',2);
INSERT INTO `Recurso` (`id`, `controllerBean`, `icon`, `indexPage`, `locationOfFiles`, `name`, `objectClass`, `idDomain`) VALUES (14,'ChamadaController','imagens/info.ico','list','academico/chamada/','Chamada','Chamada',2);
INSERT INTO `Recurso` (`id`, `controllerBean`, `icon`, `indexPage`, `locationOfFiles`, `name`, `objectClass`, `idDomain`) VALUES (15,'NotaController','imagens/info.ico','list','academico/nota/','Nota','Nota',2);
INSERT INTO `Recurso` (`id`, `controllerBean`, `icon`, `indexPage`, `locationOfFiles`, `name`, `objectClass`, `idDomain`) VALUES (16,'MatrizCurricularController','imagens/info.ico','list','academico/matriz/','Matriz Curricular','MatrizCurricular',2);


INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (1,'pgNew','apps/confApp/action/new.jsf','new',1);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (2,'pgList','apps/confApp/action/list.jsf','list',1);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (3,'pgEdit','apps/confApp/action/edit.jsf','edit',1);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (4,'pgView','apps/confApp/action/view.jsf','view',1);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (5,'pgNew','apps/confApp/domain/new.jsf','new',2);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (6,'pgList','apps/confApp/domain/list.jsf','list',2);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (7,'pgEdit','apps/confApp/domain/edit.jsf','edit',2);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (8,'pgView','apps/confApp/domain/view.jsf','view',2);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (9,'pgNew','apps/confApp/group/new.jsf','new',3);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (10,'pgList','apps/confApp/group/list.jsf','list',3);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (11,'pgEdit','apps/confApp/group/edit.jsf','edit',3);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (12,'pgView','apps/confApp/group/view.jsf','view',3);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (13,'pgNew','apps/confApp/resource/new.jsf','new',4);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (14,'pgList','apps/confApp/resource/list.jsf','list',4);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (15,'pgEdit','apps/confApp/resource/edit.jsf','edit',4);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (16,'pgView','apps/confApp/resource/view.jsf','view',4);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (17,'pgPages','apps/confApp/resource/pages.jsf','pages',4);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (18,'pgNew','apps/confApp/user/new.jsf','new',5);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (19,'pgList','apps/confApp/user/list.jsf','list',5);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (20,'pgEdit','apps/confApp/user/edit.jsf','edit',5);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (21,'pgView','apps/confApp/user/view.jsf','view',5);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (22,'pgNew','apps/academico/curso/new.jsf','new',6);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (23,'pgList','apps/academico/curso/list.jsf','list',6);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (24,'pgEdit','apps/academico/curso/edit.jsf','edit',6);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (25,'pgNew','apps/academico/disciplina/new.jsf','new',7);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (26,'pgList','apps/academico/disciplina/list.jsf','list',7);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (27,'pgEdit','apps/academico/disciplina/edit.jsf','edit',7);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (28,'pgNew','apps/academico/turma/new.jsf','new',8);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (29,'pgList','apps/academico/turma/list.jsf','list',8);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (30,'pgEdit','apps/academico/turma/edit.jsf','edit',8);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (31,'pgNew','apps/pessoa/administrador/new.jsf','new',9);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (32,'pgList','apps/pessoa/administrador/list.jsf','list',9);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (33,'pgEdit','apps/pessoa/administrador/edit.jsf','edit',9);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (34,'pgNew','apps/pessoa/aluno/new.jsf','new',10);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (35,'pgList','apps/pessoa/aluno/list.jsf','list',10);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (36,'pgEdit','apps/pessoa/aluno/edit.jsf','edit',10);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (37,'pgNew','apps/pessoa/docente/new.jsf','new',11);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (38,'pgList','apps/pessoa/docente/list.jsf','list',11);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (39,'pgEdit','apps/pessoa/docente/edit.jsf','edit',11);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (40,'pgNew','apps/academico/grade/new.jsf','new',12);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (41,'pgList','apps/academico/grade/list.jsf','list',12);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (42,'pgEdit','apps/academico/grade/edit.jsf','edit',12);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (43,'pgNew','apps/academico/plano/new.jsf','new',13);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (44,'pgList','apps/academico/plano/list.jsf','list',13);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (45,'pgEdit','apps/academico/plano/edit.jsf','edit',13);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (46,'pgNew','apps/academico/chamada/new.jsf','new',14);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (47,'pgList','apps/academico/chamada/list.jsf','list',14);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (48,'pgEdit','apps/academico/chamada/edit.jsf','edit',14);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (49,'pgNew','apps/academico/nota/new.jsf','new',15);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (50,'pgList','apps/academico/nota/list.jsf','list',15);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (51,'pgEdit','apps/academico/nota/edit.jsf','edit',15);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (52,'pgNew','apps/academico/matriz/new.jsf','new',16);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (53,'pgList','apps/academico/matriz/list.jsf','list',16);
INSERT INTO `ResourceFile` (`id`, `codeFile`, `file`, `pageURL`, `idResource`) VALUES (54,'pgEdit','apps/academico/matriz/edit.jsf','edit',16);


INSERT INTO `Acao` (`id`, `classColor`, `code`, `icon`, `method`, `name`, `updateComponent`, `typeComponet`) VALUES	(1,'grey','actNew','icon-file','new','Novo',':frm', 0);
INSERT INTO `Acao` (`id`, `classColor`, `code`, `icon`, `method`, `name`, `updateComponent`, `typeComponet`) VALUES	(2,'warning','actList','icon-align-justify','list','Listar',':frm', 0);
INSERT INTO `Acao` (`id`, `classColor`, `code`, `icon`, `method`, `name`, `updateComponent`, `typeComponet`) VALUES	(3,'primary','actEdit','icon-edit','edit','Editar',':frm', 0);
INSERT INTO `Acao` (`id`, `classColor`, `code`, `icon`, `method`, `name`, `updateComponent`, `typeComponet`) VALUES	(4,'info','actView','icon-eye-open','view','Exibir',':frm', 0);
INSERT INTO `Acao` (`id`, `classColor`, `code`, `icon`, `method`, `name`, `updateComponent`, `typeComponet`) VALUES	(5,'success','actSave','icon-save','save()','Salvar',':frm', 7);
INSERT INTO `Acao` (`id`, `classColor`, `code`, `icon`, `method`, `name`, `updateComponent`, `typeComponet`) VALUES	(6,'danger','actDelete','icon-trash','delete()','Excluir',':frm', 7);
INSERT INTO `Acao` (`id`, `classColor`, `code`, `icon`, `method`, `name`, `updateComponent`, `typeComponet`) VALUES	(7,'inverse','actReturn','icon-undo','edit','Retornar',':frm', 0);


INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (1,1);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (1,2);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (1,3);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (1,4);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (1,5);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (1,6);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (2,1);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (2,2);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (2,3);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (2,4);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (2,5);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (2,6);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (3,1);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (3,2);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (3,3);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (3,4);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (3,5);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (3,6);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (4,1);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (4,2);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (4,3);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (4,4);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (4,5);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (4,6);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (4,7);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (5,1);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (5,2);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (5,3);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (5,4);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (5,5);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (5,6);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (6,1);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (6,2);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (6,3);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (6,5);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (7,1);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (7,2);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (7,3);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (7,5);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (8,1);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (8,2);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (8,3);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (8,5);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (9,1);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (9,2);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (9,3);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (9,5);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (10,1);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (10,2);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (10,3);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (10,5);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (11,1);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (11,2);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (11,3);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (11,5);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (12,1);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (12,2);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (12,3);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (12,5);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (13,1);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (13,2);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (13,3);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (13,5);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (14,1);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (14,2);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (14,3);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (14,5);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (15,1);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (15,2);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (15,3);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (15,5);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (16,1);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (16,2);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (16,3);
INSERT INTO `ActionResource` (`idResource`, `idAction`) VALUES (16,5);


/* Recurso Acao pagina New */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (1,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (1,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (1,5);
/* Recurso Acao pagina List */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (2,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (2,3);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (2,4);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (2,6);
/* Recurso Acao pagina Edit */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (3,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (3,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (3,5);
/* Recurso Acao pagina View */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (4,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (4,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (4,3);
/* Recurso Dominio pagina New */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (5,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (5,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (5,5);
/* Recurso Dominio pagina List */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (6,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (6,3);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (6,4);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (6,6);
/* Recurso Dominio pagina Edit */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (7,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (7,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (7,5);
/* Recurso Dominio pagina View */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (8,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (8,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (8,3);
/* Recurso Grupo pagina New */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (9,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (9,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (9,5);
/* Recurso Grupo pagina List */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (10,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (10,3);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (10,4);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (10,6);
/* Recurso Grupo pagina Edit */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (11,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (11,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (11,5);
/* Recurso Grupo pagina View */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (12,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (12,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (12,3);
/* Recurso Recurso pagina New */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (13,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (13,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (13,5);
/* Recurso Recurso pagina List */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (14,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (14,3);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (14,4);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (14,6);
/* Recurso Recurso pagina Edit */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (15,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (15,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (15,5);
/* Recurso Recurso pagina View */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (16,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (16,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (16,3);
/* Recurso Recurso pagina Pages */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (17,5);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (17,7);
/* Recurso Usuario pagina New */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (18,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (18,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (18,5);
/* Recurso Usuario pagina List */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (19,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (19,3);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (19,4);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (19,6);
/* Recurso Usuario pagina Edit */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (20,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (20,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (20,5);
/* Recurso Usuario pagina View */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (21,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (21,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (21,3);
/* Recurso Curso pagina New */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (22,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (22,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (22,5);
/* Recurso Curso pagina List */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (23,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (23,3);
/* Recurso Curso pagina Edit */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (24,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (24,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (24,5);
/* Recurso Disciplina pagina New */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (25,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (25,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (25,5);
/* Recurso Disciplina pagina List */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (26,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (26,3);
/* Recurso Disciplina pagina Edit */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (27,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (27,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (27,5);
/* Recurso Turma pagina New */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (28,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (28,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (28,5);
/* Recurso Turma pagina List */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (29,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (29,3);
/* Recurso Turma pagina Edit */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (30,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (30,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (30,5);
/* Recurso Administrador pagina New */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (31,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (31,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (31,5);
/* Recurso Administrador pagina List */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (32,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (32,3);
/* Recurso Administrador pagina Edit */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (33,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (33,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (33,5);
/* Recurso Aluno pagina New */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (34,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (34,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (34,5);
/* Recurso Aluno pagina List */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (35,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (35,3);
/* Recurso Aluno pagina Edit */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (36,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (36,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (36,5);
/* Recurso Docente pagina New */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (37,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (37,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (37,5);
/* Recurso Docente pagina List */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (38,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (38,3);
/* Recurso Docente pagina Edit */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (39,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (39,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (39,5);
/* Recurso Grade pagina New */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (40,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (40,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (40,5);
/* Recurso Grade pagina List */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (41,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (41,3);
/* Recurso Grade pagina Edit */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (42,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (42,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (42,5);
/* Recurso Plano de Estudo pagina New */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (43,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (43,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (43,5);
/* Recurso Plano de Estudo pagina List */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (44,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (44,3);
/* Recurso Plano de Estudo pagina Edit */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (45,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (45,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (45,5);
/* Recurso Chamada pagina New */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (46,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (46,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (46,5);
/* Recurso Chamada pagina List */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (47,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (47,3);
/* Recurso Chamada pagina Edit */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (48,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (49,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (49,5);
/* Recurso Grade pagina New */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (40,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (40,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (40,5);
/* Recurso Grade pagina List */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (41,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (41,3);
/* Recurso Grade pagina Edit */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (42,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (42,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (42,5);
/* Recurso Plano de Estudo pagina New */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (43,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (43,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (43,5);
/* Recurso Plano de Estudo pagina List */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (44,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (44,3);
/* Recurso Plano de Estudo pagina Edit */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (45,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (45,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (45,5);
/* Recurso Chamada pagina New */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (46,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (46,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (46,5);
/* Recurso Chamada pagina List */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (47,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (47,3);
/* Recurso Chamada pagina Edit */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (48,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (48,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (48,5);
/* Recurso Plano de Estudo pagina New */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (49,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (49,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (49,5);
/* Recurso Plano de Estudo pagina List */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (50,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (50,3);
/* Recurso Plano de Estudo pagina Edit */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (51,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (51,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (51,5);
/* Recurso Chamada pagina New */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (52,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (52,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (52,5);
/* Recurso Chamada pagina List */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (53,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (53,3);
/* Recurso Chamada pagina Edit */
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (54,1);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (54,2);
INSERT INTO `ActionsFile` (`idFile`, `idAction`) VALUES (54,5);


INSERT INTO `Grupo` (`id`, `description`, `name`) VALUES (1,'Administrador todo o sistema.','SYS - ADMIN');
INSERT INTO `Grupo` (`id`, `description`, `name`) VALUES (2,'Administrar a todo o sistema acadêmico.','Administradores');
INSERT INTO `Grupo` (`id`, `description`, `name`) VALUES (3,'Grupo de Professores.','Professores');
INSERT INTO `Grupo` (`id`, `description`, `name`) VALUES (4,'Grupo de Alunos.','Alunos');


INSERT INTO `Usuario` (`id`, `active`, `email`, `keyUser`, `name`, `password`) VALUES (1,1,'william.rodrigues@live.fae.edu','williamrodrigues','William  Rodrigues',MD5('123456'));
INSERT INTO `Usuario` (`id`, `active`, `email`, `keyUser`, `name`, `password`) VALUES (2,1,'eab@live.fae.edu','ericsonbaggio','Ericson Baggio',MD5('123456'));
INSERT INTO `Usuario` (`id`, `active`, `email`, `keyUser`, `name`, `password`) VALUES (3,1,'fred@live.fae.edu','fredricchien','Frederic Chien',MD5('123456'));


INSERT INTO `UserGroup` (`idUser`, `idGroup`) VALUES (1,1);
INSERT INTO `UserGroup` (`idUser`, `idGroup`) VALUES (2,1);
INSERT INTO `UserGroup` (`idUser`, `idGroup`) VALUES (3,1);
INSERT INTO `UserGroup` (`idUser`, `idGroup`) VALUES (1,2);
INSERT INTO `UserGroup` (`idUser`, `idGroup`) VALUES (2,2);
INSERT INTO `UserGroup` (`idUser`, `idGroup`) VALUES (3,2);


INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (1,1,1,1);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (2,2,1,1);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (3,3,1,1);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (4,4,1,1);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (5,5,1,1);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (6,6,1,1);
/* Permissao para Dominio */
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (7,1,2,1);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (8,2,2,1);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (9,3,2,1);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (10,4,2,1);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (11,5,2,1);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (12,6,2,1);
/* Permissao para Grupo */
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (13,1,3,1);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (14,2,3,1);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (15,3,3,1);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (16,4,3,1);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (17,5,3,1);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (18,6,3,1);
/* Permissao para Recurso */
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (19,1,4,1);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (20,2,4,1);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (21,3,4,1);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (22,4,4,1);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (23,5,4,1);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (24,6,4,1);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (25,7,4,1);
/* Permissao para Usuario */
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (26,1,5,1);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (27,2,5,1);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (28,3,5,1);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (29,4,5,1);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (30,5,5,1);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (31,6,5,1);
/* Permissao para Curso */
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (32,1,6,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (33,2,6,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (34,3,6,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (35,5,6,2);
/* Permissao para Disciplina */
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (36,1,7,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (37,2,7,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (38,3,7,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (39,5,7,2);
/* Permissao para Turma */
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (40,1,8,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (41,2,8,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (42,3,8,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (43,5,8,2);
/* Permissao para Administrador */
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (44,1,9,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (45,2,9,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (46,3,9,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (47,5,9,2);
/* Permissao para Aluno */
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (48,1,10,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (49,2,10,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (50,3,10,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (51,5,10,2);
/* Permissao para Docente */
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (52,1,11,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (53,2,11,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (54,3,11,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (55,5,11,2);
/* Permissao para Grade */
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (56,1,12,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (57,2,12,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (58,3,12,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (59,5,12,2);
/* Permissao para Plano de Estudo */
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (60,1,13,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (61,2,13,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (62,3,13,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (63,5,13,2);
/* Permissao para Chamada */
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (64,1,14,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (65,2,14,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (66,3,14,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (67,5,14,2);
/* Permissao para Nota */
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (68,1,15,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (69,2,15,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (70,3,15,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (71,5,15,2);
/* Permissao para Matriz Curricular */
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (72,1,16,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (73,2,16,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (74,3,16,2);
INSERT INTO `Permissao` (`id`, `idAction`, `idResource`, `idGroup`) VALUES (75,5,16,2);