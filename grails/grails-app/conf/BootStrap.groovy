class BootStrap {

	def init = {  servletContext ->
//		SpringSecurityUtils.clientRegisterFilter(
//				'loginFilter', SecurityFilterPosition.OPENID_FILTER.order + 10)
	}
	def destroy = {
	}
}
