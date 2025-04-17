--删除 000-999 分区的数据
CREATE OR REPLACE PROCEDURE WXPT.DELETE_PARTITION_SELF_FACE_DETAIL AS
  -- 常量定义
  c_batch_size      CONSTANT NUMBER := 5000;      -- 每次删除的批次大小
  c_start_partition CONSTANT NUMBER := 0;         -- 起始分区号
  c_end_partition   CONSTANT NUMBER := 999;       -- 结束分区号
  c_etl_time        CONSTANT DATE := TO_DATE('2025-04-12 02:41:19', 'YYYY-MM-DD HH24:MI:SS');
  c_batch_no        CONSTANT VARCHAR2(20) := '20250407069';
  c_batch_time      CONSTANT DATE := TO_DATE('2025-04-07 00:00:00', 'YYYY-MM-DD HH24:MI:SS');

  -- 变量定义
  v_partition_name  VARCHAR2(100);
  v_sql             VARCHAR2(1000);
  v_deleted_total   NUMBER := 0;
  v_deleted_part    NUMBER;
BEGIN

  -- 主处理循环
FOR i IN c_start_partition..c_end_partition LOOP
    -- 生成分区名
    v_partition_name := 'P202504_' || LPAD(i, 3, '0');
    v_deleted_part := 0;

    -- 动态SQL（使用绑定变量）
    v_sql := 'DELETE FROM WX_ZGTB_SELF_FACE_DETAIL PARTITION(' || v_partition_name || ')
              WHERE ETL_TIME = :etl_time
                AND BATCH_NO = :batch_no
                AND BATCH_TIME = :batch_time
                AND ROWNUM <= :batch_size';

    -- 当前分区处理循环
    LOOP
EXECUTE IMMEDIATE v_sql
        USING c_etl_time, c_batch_no, c_batch_time, c_batch_size;

      v_deleted_part := v_deleted_part + SQL%ROWCOUNT;

      -- 如果没有数据被删除，则退出循环
      EXIT WHEN SQL%ROWCOUNT = 0;

      -- 提交当前批次
COMMIT;
END LOOP;

    -- 记录当前分区删除情况
    v_deleted_total := v_deleted_total + v_deleted_part;

    -- 提交当前分区所有操作
COMMIT;

END LOOP;

END DELETE_PARTITION_SELF_FACE_DETAIL;