<?php
  require 'lib/MySQL.php';

  $db = MySQL::connect(
    'driveawards', // $log
    'notexting88', // $pass
    '69.175.28.2:3306', // $dbhost
    'driveawards' // $dbName
  );

  $action = $_GET['action'];
  $matrixParams = $_GET['matrix_params'];

  switch($action)
  {
    case 'register':
      $res = MySQL::query(
        'insert',
        'users', 
        $matrixParams
      );
      break;
    case 'get':
      $res = MySQL::query(
        'select',
        'users', 
        $matrixParams
      );
      break;
    case 'save-score':
      break; 
    case 'sign-in':
      break; 

  }

  echo $res;
