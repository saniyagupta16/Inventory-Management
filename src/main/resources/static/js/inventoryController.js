angular.module('app')
.controller("inventoryController", function($scope,$http){


                     var init=function(){
                     view();
                     }

                     init();

                    function view(){
                    var url="/inventory/all";
                    $http.get(url).then(function(response){
                    $scope.inventory=response.data;
                      });
                    }

                     $scope.add=function(form){
                        url="/inventory/add";
                        $http.post(url,form).then(function(response){
                           view();
                        $scope.show="view";

                      // $scope.inventory=response.data;
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
                          //$scope.inventory=response.data;
                            view();
                          $scope.show="view";
                          });


                       }

                     $scope.delete=function(id){
                        url="inventory/delete/"+id;
                        $http.get(url).then(function(response){
                        view();

                        });

                     }




             });
