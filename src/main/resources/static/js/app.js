'use strict';
var app= angular.module("app",["ngRoute"]);
app.config(['$routeProvider',function ($routeProvider){

                $routeProvider

              .when("/home", {
                        templateUrl : "/home.html",
                        controller:"homeController"
                  })
                    .when("/inventory", {
                        templateUrl : "/inventory.html",
                        controller:"inventoryController"
                    })
                    .when("/production", {
                        templateUrl : "/production.html",
                        controller:"productionController"
                    })
                    .when("/purchase", {
                          templateUrl : "/purchase.html",
                          controller:"purchaseController"
                    })
                    .when("/user",{
                          templateUrl : "/user.html",
                           controller:"userController"

                    })

            }]);



