
var Assignments=angular.module('Assignments',['ngRoute']);
Assignments.config(function($routeProvider)
		{
	$routeProvider.when('/register',
	{
		templateUrl:'partials/register.html',
		controller:'registerController'	
	})
	.when('/login',
	{
		templateUrl:'partials/login.html',
		controller:'loginController'	
	})
	.when('/task',
	{
		templateUrl:'partials/task.html',
		controller:'taskController'	
	})
	.when('/clientHome',
	{
		templateUrl:'partials/clientHome.html',
		/*controller:'clientHomeController'*/	
	})
	.when('/logout',
	{
		templateUrl:'partials/logout.html',
		controller:'logoutController'	
	})
	
});
Assignments.controller('registerController',function($scope,$http,$rootScope)
		{
	$rootScope.login=true;
	console.log("in register");
	$scope.register=function()
	{
		var clients={
			client_Name:$scope.client_Name,
			client_Password:$scope.client_Password,
			client_Address:$scope.client_Address
		}
		var res=$http.post("http://localhost:8066/Assignments/addClient",clients);
		
		res.success(function(data,status,headers,config)
				{
			console.log("status:"+status);
				});
		}
	});
Assignments.controller('loginController',['$scope','$http','$location','$rootScope',function($scope,$http,$location,$rootScope)
		{
	         console.log("in log");
	         $scope.login=function()
	         {
	        	 var login={
	        			 client_Name:$scope.client_Name,
	        			 client_Password:$scope.client_Password
	        	 }
	        	 var res=$http.post("http://localhost:8066/Assignments/authenticateClient",login)
	        	 	.then(function(response){
	        	 		 var r=response.data.toString();
						 console.log("response:"+r);
						 if(r==1)
							{
							$rootScope.task=true;
							$rootScope.logout=true;
							$rootScope.login=false;
							$rootScope.register=false;
							$rootScope.cname=$scope.client_Name;
							$rootScope.cid=$scope.client_Id;
							console.log("cname:"+$rootScope.cname);
							$location.path('/clientHome');
							}
						if(r==0)
							{
							$scope.client_Name="";
							$scope.client_Password="";
							$scope.message="clientName/password are empty";
							$location.path('/login');
							}
						if(r==2)
						{
							
							$rootScope.register=true;
							$scope.message="clientname/password are invalid";
						$location.path('/login');
						}
	        	 	});
	        	 
	         }
		}]);
Assignments.controller('taskController',function($scope,$http,$rootScope)
		{
	$rootScope.task=true;
	$rootScope.logout=true;
	$rootScope.login=false;
	$rootScope.register=false;
	$http.get("http://localhost:8066/Assignments/viewClientTasks/"+$rootScope.cname)
    .then(function (response) {
    	
    	$scope.tasks = response.data;
    	console.log("data:"+response.data);
    });
			console.log("in task controller");
			$scope.task=function()
			{
				var task={
						task_Name:$scope.task_Name,
						task_Description:$scope.task_Description,
						task_Lastdate:$scope.task_Lastdate,
						postedBy:$rootScope.cname
						
				}
				console.log("after method");
				var res=$http.post("http://localhost:8066/Assignments/addTask",task);
				$http.get("http://localhost:8066/Assignments/viewClientTasks/"+$rootScope.cname)
		 	    .then(function (response) {$scope.tasks = response.data;});
				res.success(function(data,headers,status,config){
					$scope.message = data;
					console.log("status"+status);
				});
	
			}
	
			
			$scope.updateTask=function(task)
			{
				console.log("inside update task");
				console.log("task:"+task);
				$scope.taskupdate=task;
			}
			
			$scope.saveUpdate=function()
			
			{
				console.log("in saveupdate");
				var update=
					{
						task_Id:$scope.taskupdate.task_Id,
						task_Name:$scope.taskupdate.task_Name,
						task_Description:$scope.taskupdate.task_Description,
						task_Lastdate:$scope.taskupdate.task_Lastdate
					}
				$http.put("http://localhost:8066/Assignments/updateTask",update);
				$http.get("http://localhost:8066/Assignments/viewClientTasks/"+$rootScope.cname).then(function (response) {
				    	
				    	$scope.tasks = response.data;
				    	
				    	console.log("data:"+response.data);
				    });
				
			}
			
			
$scope.finished=function(task)
{
	
	console.log("inside appdisappblog");
	console.log("adminblog:"+task);
	$scope.taskstatus=task;
	
}

$scope.finishedTask=function()
{
	
	console.log("status:"+$scope.taskstatus);
	console.log("in finishedtask");
	var finished=
		{
			task_Id:$scope.taskstatus.task_Id,
			task_Name:$scope.taskstatus.task_Name,
			task_Description:$scope.taskstatus.task_Description,
			task_Lastdate:$scope.taskstatus.task_Lastdate,
			postedBy:$scope.taskstatus.postedBy,
			status:true
			
		}
	
	$http.put("http://localhost:8066/Assignments/updateTask",finished);
	 $http.get("http://localhost:8066/Assignments/viewClientTasks/"+$rootScope.cname)
	    .then(function (response) {
	    	
	    	$scope.tasks = response.data;
	    	
	    	console.log("data:"+response.data);
	    });
}
$http.get("http://localhost:8066/Assignments/viewFinishedTasks/"+$rootScope.cname).then(function (response) {
	
	$scope.finishedtasks = response.data;
	
	console.log("data:"+response.data);
});
});
Assignments.controller('logoutController',function($scope,$rootScope)
{
	$rootScope.task=false;
	$rootScope.logout=false;
	$rootScope.login=true;
	$rootScope.register=true;
	
	});





