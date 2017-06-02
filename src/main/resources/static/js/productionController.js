angular.module('app')
.controller("productionController", function($scope,$http){


                        $scope.production = {};
                        $scope.productionInventoryItem= [];
                        function int (){
                        $scope.production={};
                        var url="/inventory/all";
                          $http.get(url).then(function(response){
                          $scope.productionitem=response.data;

                          });
                            view();
                          }

                          int();
                        $scope.Order={};
                       function view(){
                           var url="/production/all";
                           $http.get(url).then(function(response){
                           $scope.Order=response.data;
                           });
                       }



                        $scope.pur={
                        production_inventory_items:[{
                        'purchaseId':1,
                        'purchaseQty':1}
                        ]};
                        $scope.addNewChoice = function(data) {

                        $scope.production.productionInventoryItem = [];
                          var arr = [];
                          for(var i=0;i<data.production_inventory_items.length;i++){
                          var temp ={};
                            temp.id=data.production_inventory_items[i].purchaseId;
                            temp.quantity = data.production_inventory_items[i].purchaseQty;
                            if(temp!=null)
                                arr.push(temp);
                        }

                          /* $scope.purchaseOrder.inventoryItems = JSON.stringify(arr);*/
                             $scope.productionInventoryItem = arr;
                           console.log($scope.productionInventoryItem);

                            $scope.pur.production_inventory_items.push({'purchaseId':'','purchaseQty':''});
                      };

                      $scope.removeChoice = function(z) {
                       // var lastItem = $scope.choices.length-1;
                        $scope.pur.production_inventory_items.splice(z,1);
                      };

                      $scope.addProduction=function(data){
                      $scope.production.production_item=data.production_item
                      $scope.production.production_date=data.production_date

                            //$scope.purchaseOrder.inventoryItems=[];
                            //$scope.purchaseOrder.inventoryItems=data.inventoryItems;
                      $scope.production.productionInventoryItem=angular.copy($scope.productionInventoryItem);
                      console.log($scope.production);
                      var url="/production/add";
                      $http.post(url,$scope.production,$scope.productionInventoryItem).then(function(response){
                      view();
                      $scope.show="view";
                     $scope.production=response.data;
                               });
                       }

                      $scope.refreshView=function(id){
                      if(id==0){
                        view();
                      }
                      else{
                       url="production/details/"+id;
                       $http.get(url).then(function(response){

                                             $scope.Order=response.data;

                                             });
                      }

                       }



                     $scope.deleteProduction=function(id){
                                             url="production/delete/"+id;
                                             $http.get(url).then(function(response){
                                             view();

                                             });

                                          }



              });