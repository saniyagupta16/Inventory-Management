angular.module('app')
.controller("userController", function($scope,$http){

                        var init=function(){
                             $scope.roles = ["Admin", "PO", "Production"];
                             view();
                        }

                        init();

                        function view(){
                            var url="/user/all";
                            $http.get(url).then(function(response){
                            $scope.user=response.data;
                            });
                        }

                        $scope.addUser=function(userInfo){
                        url="/user/add";
                        $http.post(url,userInfo).then(function(response){
                         $scope.show="view";
                           view();
//                         $scope.inventory=response.data;
                              });
                        }

                        $scope.edit=function(item){
                                              $scope.show="edit";
                                              $scope.invDetail=[];
                                              $scope.invDetail = angular.copy(item);

                                          }

                                            $scope.editInventory=function(item){
                                               url="/inventory/edit/"+item.id;
                                               $http.put(url,item).then(function(response){
                                               $scope.inventory=response.data;

                                               $scope.show="view";
                                               });


                                            }

                                          $scope.deleteUser=function(id){
                                             url="user/delete/"+id;
                                             $http.get(url).then(function(response){
                                             view();

                                             });

                                          }

//                         $scope.purchaseOrderItemDelatis=function(id){
//                              url="purchase/itemdetails/"+id;
//                              $http.get(url).then(function(response){
//
//                               $scope.ItemDetails=response.data;
//
//                               });
//
//                          }




               });