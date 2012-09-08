<?php
class MySQL {

  static private $db;

  static function connect($log='', $pass='', $dbhost='', $dbName=''){

    if( is_null(self::$db) ){

      self::$db = mysql_connect($dbhost, $log, $pass) or die(mysql_error() );
      mysql_select_db($dbName, self::$db) or die(mysql_error() );
    }
    return self::$db;
  }

  static function query($task, $table, $matrixParams) {

    $parsedMatrixParams = self::parseMatrixParams($task, $matrixParams);

    switch($task) {
      case 'insert':
        $sql = self::buildInsertQuery(
          $table, 
          $parsedMatrixParams['keys'],
          $parsedMatrixParams['values']
        );
        break;
      case 'select':
        $sql = self::buildSelectQuery(
          $table,
          $parsedMatrixParams['selects'],
          $parsedMatrixParams['keysValues']
        );
        break;
    } // end switch

    $res = mysql_query($sql);

    if ( $row = mysql_fetch_array($res, MYSQL_ASSOC) )
    {
      $ret = array_pop($row);
    }
    else
    {
      $ret = $res;
    }

    mysql_free_result($res);

    return $ret;

  }

  private static function buildInsertQuery($table, $keys, $values) {
    return 'INSERT INTO ' . $table . ' (' . implode($keys, ', ') . ') VALUES (' . implode($values, ', ') . ')';
  }

  private static function buildSelectQuery($table, $selects, $keysValues) {
    return 'SELECT ' . implode($selects, ', ')  . ' FROM ' . $table . ' WHERE (' . implode($keysValues, ' AND ') . ')';
  }

  private static function parseMatrixParams($task, $matrixParams)
  {

      $keys = array();
      $values = array();
      $keysValues = array();
      $selects = array();

      $matrixParams = explode(';', $matrixParams);

      foreach($matrixParams as $keyValue)
      {
        $keyValue = explode('=', $keyValue);
        if( empty($keyValue[1]) )
        {
          $selects[] = $keyValue[0];
        }
        else if ($task !== 'select')
        {
          $keys[] = $keyValue[0];
          $values[] = '\'' . $keyValue[1] . '\'';
        }
        else if ($task === 'select')
        {
          $keysValues[] = $keyValue[0] . '=' . '\'' . $keyValue[1] . '\'';
        }
      }

      if($task === 'select')
      {
        $ret = array('keysValues' => $keysValues );
        $ret['selects'] = $selects;
      }
      else if ($task !== 'select')
      {
        $ret = array( 'keys' => $keys, 'values' => $values );
      }

      return $ret;

  }

}