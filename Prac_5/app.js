// Define AngularJS module
var app = angular.module("studentApp", []);

// Define Controller
app.controller("StudentController", function ($scope) {
  // Model: initial data
  $scope.students = [
    { name: "Rahul", branch: "CSE" },
    { name: "Priya", branch: "IT" },
    { name: "Amit", branch: "ECE" },
  ];

  // Add Student (Controller logic)
  $scope.addStudent = function () {
    if (
      $scope.newStudent &&
      $scope.newStudent.name &&
      $scope.newStudent.branch
    ) {
      $scope.students.push({
        name: $scope.newStudent.name,
        branch: $scope.newStudent.branch,
      });
      $scope.newStudent = {}; // clear input fields
    }
  };
});
