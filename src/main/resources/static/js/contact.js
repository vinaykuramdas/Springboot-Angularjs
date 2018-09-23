var con = angular.module("contact", ["ngRoute"]);
con.controller("con-controller", function($http,$scope,$window,$log) {
	
	$scope.name="";
	$scope.email="";
	$scope.message="";
	
	$scope.sendEmail = function(){
		$http({
			method: 'GET',
            url: '/sendEmail',
            data:$scope.name+$scope.email+$scope.message
           
            })
            .then(function(response) {
            	$log.info(response);
       	$window.alert("your response is submitted successfully.\nwe will reach you with in 24 hours!\nThanks for your patience.");		
		});
		
	 	$window.alert("your response is submitted successfully.\nwe will reach you with in 24 hours!\nThanks for your patience.");	
		
		$window.location.href="./home.html";
			
	};
	
});

con.config(function($routeProvider) {
	$routeProvider.when("/sendEmail"+$scope.name+$scope.email+$scope.message, 
			{controller:"con-controller"});
	
});
