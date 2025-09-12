var app = angular.module("crudApp", []);

app.controller("myCtrl", function ($scope) {
  $scope.students = [];
  $scope.newStudent = {};
  $scope.editingId = null;

  function resetNew() {
    $scope.newStudent = {};
    $scope.editingId = null;
  }

  $scope.saveRecord = function () {
    if ($scope.editingId === null) {
      var nextId = $scope.students.length
        ? Math.max(...$scope.students.map((s) => s.id)) + 1
        : 1;
      $scope.newStudent.id = nextId;
      $scope.students.push(angular.copy($scope.newStudent));
    } else {
      var idx = $scope.students.findIndex((s) => s.id === $scope.editingId);
      if (idx !== -1) {
        $scope.students[idx] = angular.copy($scope.newStudent);
      }
    }
    resetNew();
  };

  $scope.edit = function (id) {
    var student = $scope.students.find((s) => s.id === id);
    if (student) {
      $scope.newStudent = angular.copy(student);
      $scope.editingId = id;
    }
  };

  $scope.delete = function (id) {
    var idx = $scope.students.findIndex((s) => s.id === id);
    if (idx !== -1) $scope.students.splice(idx, 1);
    if ($scope.editingId === id) resetNew();
  };

  $scope.reset = resetNew;
});
