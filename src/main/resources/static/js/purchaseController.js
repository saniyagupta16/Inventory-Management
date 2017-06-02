angular.module('app')
.controller("purchaseController", function($scope,$http){


                        $scope.purchaseOrder = {};
                        $scope.inventoryItems = [];
                        function int (){
                        $scope.purchaseOrder={};
                        var url="/inventory/all";
                          $http.get(url).then(function(response){
                          $scope.purchaseitem=response.data;

                          });
                            view();
                          }

                          int();
                        $scope.Order={};
                       function view(){
                           var url="/purchaseOrder/all";
                           $http.get(url).then(function(response){
                           $scope.Order=response.data;
                           });
                       }



                        $scope.pur={
                        inventory_items:[{
                        'purchaseId':1,
                        'purchaseQty':1}
                        ]};
                        $scope.addNewChoice = function(data) {

                        $scope.purchaseOrder.inventoryItems = [];
                          var arr = [];
                          for(var i=0;i<data.inventory_items.length;i++){
                          var temp ={};
                            temp.id=data.inventory_items[i].purchaseId;
                            temp.quantity = data.inventory_items[i].purchaseQty;
                            if(temp!=null)
                                arr.push(temp);
                        }

                          /* $scope.purchaseOrder.inventoryItems = JSON.stringify(arr);*/
                             $scope.inventoryItems = arr;
                           console.log($scope.inventoryItems);
                           //var length = data.inventory_items.length - 1;
                            $scope.pur.inventory_items.push({'purchaseId':'','purchaseQty':''});
                      };

                      $scope.removeChoice = function(z) {
                       // var lastItem = $scope.choices.length-1;
                        $scope.pur.inventory_items.splice(z,1);
                      };

                      $scope.addPurchaseOrder=function(data){
                      $scope.purchaseOrder.vendor_name=data.vendor_name
                      $scope.purchaseOrder.purchase_order_date=data.purchase_order_date
                      $scope.purchaseOrder.tax=data.tax;
                            //$scope.purchaseOrder.inventoryItems=[];
                            //$scope.purchaseOrder.inventoryItems=data.inventoryItems;
                      $scope. purchaseOrder.inventoryItems=angular.copy($scope.inventoryItems);
                      console.log($scope.purchaseOrder);
                      var url="/purchaseOrder/add";
                      $http.post(url,$scope.purchaseOrder,$scope.inventoryItems).then(function(response){
                      view();
                      $scope.show="view";
                     $scope.purchaseOrder=response.data;
                               });
                       }

                      $scope.refreshView=function(id){
                      if(id==0){
                        view();
                      }
                      else{
                       url="purchaseOrder/details/"+id;
                       $http.get(url).then(function(response){

                                             $scope.Order=response.data;

                                             });
                      }

                       }



                     $scope.deletePurchaseOrder=function(id){
                                             url="purchaseOrder/delete/"+id;
                                             $http.get(url).then(function(response){
                                             view();

                                             });

                                          }



              });