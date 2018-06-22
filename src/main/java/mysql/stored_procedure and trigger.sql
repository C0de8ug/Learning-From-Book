DELIMITER $

CREATE TRIGGER fortest AFTER INSERT ON trace_publish

FOR EACH ROW

  BEGIN

    CALL fortest( NEW.trace_instance_index_id, NEW.trace_template_dict_id);

  END

  $



  DELIMITER $

CREATE PROCEDURE fortest(IN trace_instance_index_id VARCHAR(24), IN trace_template_dict_id VARCHAR(24))

BEGIN

  IF trace_template_dict_id = 'TraceT0000055BWV'
  THEN

    INSERT INTO test (t1, t2) VALUES (trace_instance_index_id, trace_template_dict_id);

    SELECT
      ysyf,
      ysnf
    FROM htoa_yssq_

         DECLARE done INT DEFAULT 0;


    DECLARE v_buget_year         VARCHAR(255);

      DECLARE v_buget_month_temp VARCHAR(255);

      DECLARE v_buget_item       VARCHAR(255);

      DECLARE v_hr_dept_id       VARCHAR(255);

      DECLARE v_buget_item_id    VARCHAR(255);

      DECLARE v_buget_account    DECIMAL(13, 2);

      DECLARE v_buget_index_id   VARCHAR(255);

      DECLARE v_buget_month      INT(11);

      DECLARE v_buget_period     INT(11);

    SELECT sqnf
    FROM htoa_yssq
    WHERE trace_instance_index_id = trace_instance_index_id INTO v_buget_year;

    SELECT sqyf
    FROM htoa_yssq
    WHERE trace_instance_index_id = trace_instance_index_id INTO v_buget_month_temp;

    CASE v_buget_month_temp

      WHEN '全年'
      THEN

        v_buget_period = 0;

        v_buget_month = NULL;

      WHEN '上半年'
      THEN

        v_buget_period = 1;

        v_buget_month = 0;

      WHEN '下半年'
      THEN

        v_buget_period = 1;

        v_buget_month = 1;

      WHEN '第一季'
      THEN

        v_buget_period = 2;

        v_buget_month = 1;

      WHEN '第二季'
      THEN

        v_buget_period = 2;

        v_buget_month = 2;

      WHEN '第三季'
      THEN

        v_buget_period = 2;

        v_buget_month = 3;

      WHEN '第四季'
      THEN

        v_buget_period = 2;

        v_buget_month = 4;

      WHEN '一月'
      THEN

        v_buget_period = 3;

        v_buget_month = 1;

      WHEN '二月'
      THEN

        v_buget_period = 3;

        v_buget_month = 2;

      WHEN '三月'
      THEN

        v_buget_period = 3;

        v_buget_month = 3;

      WHEN '四月'
      THEN

        v_buget_period = 3;

        v_buget_month = 4;

      WHEN '五月'
      THEN

        v_buget_period = 3;

        v_buget_month = 5;

      WHEN '六月'
      THEN

        v_buget_period = 3;

        v_buget_month = 6;

      WHEN '七月'
      THEN

        v_buget_period = 3;

        v_buget_month = 7;

      WHEN '八月'
      THEN

        v_buget_period = 3;

        v_buget_month = 8;

      WHEN '九月'
      THEN

        v_buget_period = 3;

        v_buget_month = 9;

      WHEN '十月'
      THEN

        v_buget_period = 3;

        v_buget_month = 10;

      WHEN '十一月'
      THEN

        v_buget_period = 3;

        v_buget_month = 11;

      WHEN '十二月'
      THEN

        v_buget_period = 3;

        v_buget_month = 12;

    END CASE

    DECLARE mxb CURSOR

    FOR

    SELECT
      hr_dept_id,
      buget_item_id,
      buget_account
    FROM htoa_yssq_mxb
    WHERE trace_instance_index_id = trace_instance_index_id INTO buget_item_id, buget_account;

    DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET done = 1;

      OPEN           mxb;


      REPEAT

                     FETCH mxb INTO hr_dept_id, buget_item_id, buget_account;

    SELECT buget_index_id
    FROM buget_index
    WHERE buget_year = buget_year AND buget_dept = buget_dept AND STATUS = 1 INTO v_buget_index_id;

    UPDATE buget_detail
    SET buget_account = buget_account + v_buget_account
    WHERE buget_item_id = v_buget_item_id AND buget_index_id = v_buget_index_id AND buget_period = v_buget_period AND
          buget_month = v_buget_month;


    UNTIL done END REPEAT;


  CLOSE mxb;


END IF;

END

$




DELIMITER $

CREATE TRIGGER fortest AFTER INSERT ON test

FOR EACH ROW

  BEGIN

    DECLARE t varchar(24);
    SELECT t1 FROM test WHERE t1 = "t1"  limit 1 into t;

    IF (t is NULL ) THEN
      UPDATE temp SET t2 = t2 + 1 where t1 = "1";
    END IF ;

  END

  $