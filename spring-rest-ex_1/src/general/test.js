{
	$("#run")
			.click(
					function() {
						log = function(msg, json) {
							$('#log').before("<hr/><b>" + msg + "</b>");
							$('#log').before(
									"<pre>"
											+ JSON
													.stringify(json, undefined,
															2) + "</pre>");
						};
						CSClient
								.createCo("/Person", {
									firstName : "John",
									lastName : "Smith"
								}, {
									systemName : "Admin"
								})
								.then(
										function(result) {
											log("PERSON CREATED:", result);
											return CSClient.readCo("/Person/"
													+ result.Person.rowidObject
															.trim(), {
												depth : 1
											});
										})
								.then(
										function(result) {
											log("READ CREATED PERSON:", result);
											return CSClient
													.updateCo(
															"/Person/"
																	+ result.rowidObject
																			.trim(),
															{
																genderCd : {
																	genderCode : "M"
																},
																TelephoneNumbers : {
																	item : [
																			{
																				phoneNumber : "111-11-11"
																			},
																			{
																				phoneNumber : "222-22-22"
																			} ]
																}
															},
															{
																systemName : "Admin"
															});
										})
								.then(
										function(result) {
											log("PERSON UPDATED:", result);
											return CSClient.readCo("/Person/"
													+ result.Person.rowidObject
															.trim(), {
												depth : 3,
												readSystemFields : true
											});
										})
								.then(
										function(result) {
											log("READ UPDATED PERSON:", result);
											return CSClient
													.deleteCo(
															"/Person/"
																	+ result.rowidObject
																			.trim()
																	+ "/TelephoneNumbers/"
																	+ result.TelephoneNumbers.item[0].rowidObject
																			.trim(),
															{
																systemName : "Admin"
															});
										})
								.then(
										function(result) {
											log("TELEPHONE DELETED:", result);
											return CSClient.readCo("/Person/"
													+ result.Person.rowidObject
															.trim(), {
												depth : 3
											});
										})
								.then(
										function(result) {
											log(
													"READ PERSON AFTER TELEPHONE IS DELETED:",
													result);
											return CSClient
													.deleteCo(
															"/Person/"
																	+ result.rowidObject
																			.trim(),
															{
																systemName : "Admin"
															});
										})
								.then(
										function(result) {
											log("PERSON DELETED:", result);
											return CSClient
													.readCo(
															"/Person/"
																	+ result.Person.rowidObject
																			.trim(),
															{
																depth : 1,
																recordStates : "ACTIVE,PENDING,DELETED",
																readSystemFields : true
															});
										})
								.then(
										function(result) {
											log(
													"READ PERSON AFTER DELETE (HSI -1):",
													result);
										});
					});
}
);