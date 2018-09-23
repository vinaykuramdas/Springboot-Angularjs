var app = angular.module("myApp", []);
app.controller("appController", function($scope, $http,$window) {
	$scope.heading = "Eircom-EirSpace";
	$scope.item = "";
	$scope.quan0 = "";
	$scope.item1 = "";
	$scope.quan1 = "";
	$scope.item2 = "";
	$scope.quan2 = "";
    $scope.price0 = "";
    $scope.tableout = "";
    $scope.total = 100;
 //   $scope.Item={item:"",quan0:"",price0:""};
    $scope.Item = {};
  
  var table =[];
	  $scope.itemList = ["idly","poori","dosa","chapathi"];
		$scope.complete0=function(string){
			
			var output=[];
			angular.forEach($scope.itemList,function(item){
				if(item.toLowerCase().indexOf(string.toLowerCase())>=0){
					output.push(item);
				}
			});
			$scope.filteritem=output;
		}
		$scope.fillTextbox0=function(string){
			$scope.Item.item=string;
			$scope.filteritem=null;
}
		$scope.total = $scope.table[1];
        console.log("total"+$scope.total)
		
       /* $scope.complete1=function(string){
			
			var output=[];
			angular.forEach($scope.itemList,function(item1){
				if(item1.toLowerCase().indexOf(string.toLowerCase())>=0){
					output.push(item1);
				}
			});
			$scope.filteritem1=output;
		}
		$scope.fillTextbox1=function(string){
			$scope.item1=string;
			$scope.filteritem1=null;
		}
		
        $scope.complete2=function(string){
			
			var output=[];
			angular.forEach($scope.itemList,function(item2){
				if(item2.toLowerCase().indexOf(string.toLowerCase())>=0){
					output.push(item2);
				}
			});
			$scope.filteritem2=output;
		}
		$scope.fillTextbox2=function(string){
			$scope.item2=string;
			$scope.filteritem2=null;
		}*/
		
		
		
		$scope.$watch('Item.item',function(){
			  if($scope.Item.item == "idly"){
				  $scope.Item.price = "20";
			  }
              if($scope.Item.item == "dosa"){
				  $scope.Item.price = "50";
			  }
              if($scope.Item.item == "poori"){
				  $scope.Item.price = "30";
			  }
              
              if($scope.Item.item == "chapathi"){
				  $scope.Item.price = "40";
			  }
			  
		  });
		
		
		var getAllItems = function(){
			var promise = $http.get('/price/getAllItems').then(function(res){
				$scope.table = res.data;
				console.log("table"+$scope.table)
				
				 
				
			});
		};
		
		
		$scope.saveItem = function(){
			
			table.push($scope.Item);
			$scope.tableout ={ table};
			console.log($scope.tableout);
			$http({
				method:"POST",
				url:"/price/addItem",
				data:angular.toJson($scope.Item)
			}).then(function(res){
				$scope.Item = {};
				getAllItems();
			});
			
		};
		
		
		
		$scope.editPerson = function(index) {
			$scope.Item = angular.copy($scope.table[index]);
		};
		$scope.removeItem = function(item){
			$http({
				method:"DELETE",
				url:"/price/deleteItem/"+item
			}).then(function(res){
				console.log("Item deleted");
				
			});
			getAllItems();
		};
		
});

