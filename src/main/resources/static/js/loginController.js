
var app=angular.module('myApp',[]);
app.controller("loginController", function($scope,$http){
               $scope.login=function(credentials){
                           url="/login/user ";
                           $http.post(url,credentials).then(function(response){
                           var authenticate=response.data;
                           if(authenticate=="Successfully login")
                                        $window.location.href = '/index.html';
                           else
                                    $scope.error="Login failed";
                                       });
                                    }


               });
