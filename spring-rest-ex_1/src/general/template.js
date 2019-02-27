(function($) {
	window.CSClient = window.CSClient
			|| {
				baseUrl : "/cmx/cs/" + "[siperian-client.orsId]",
				user : "[siperian-client.username]",
				pass : "[siperian-client.password]",
				process : function(method, url, body, params) {
					var fullUrl = this.baseUrl + url + ".json?"
							+ $.param(params);
					return $.ajax({
						method : method,
						contentType : "application/json",
						url : fullUrl,
						data : JSON.stringify(body),
						beforeSend : function(xhr) {
							xhr
									.setRequestHeader("Authorization", "Basic "
											+ btoa(CSClient.user + ":"
													+ CSClient.pass));
						}
					});
				},
				readCo : function(url, params) {
					return this.process("GET", url, null, params);
				},
				createCo : function(url, body, params) {
					return this.process("POST", url, body, params);
				},
				updateCo : function(url, body, params) {
					return this.process("PUT", url, body, params);
				},
				deleteCo : function(url, params) {
					return this.process("DELETE", url, null, params);
				}
			};
})(jQuery);