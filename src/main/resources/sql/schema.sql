-- -----------------------------------------
-- begin
-- version:1.0.0
-- author:huangting
-- description:该数据库用于支撑用电管理系统
-- time:2017/6/19
-- -----------------------------------------
CREATE DATABASE electricity;
USE electricity;

-- 学生表
CREATE TABLE student (
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '唯一标识一名学生的ID号',
  name VARCHAR(20) COMMENT '学生的名字',
  studentID VARCHAR(20) NOT NULL DEFAULT '2014213451' UNIQUE COMMENT '学生的学号',
  class VARCHAR(20) COMMENT '学生的专业班级',
  department VARCHAR(20) COMMENT '学生所在学院',
  sex INT(1) NOT NULL DEFAULT 0 COMMENT '学生的性别：0表示系统默认；1表示为女；2表示为男',
  mobile_phone VARCHAR(11) COMMENT '学生的手机号',
  mail VARCHAR(50) COMMENT '学生的邮箱',
  password VARCHAR(20) COMMENT '学生登录系统密码',
  born_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '学生被创建的时间',
  update_time TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '学生信息最后一次被修改的时间',
  dormitory_id INT COMMENT '学生所在的宿舍ID号',
  -- 级联宿舍，当宿舍的被删除时，对应的学生记录也将会被删除
  FOREIGN KEY(dormitory_id) REFERENCES dormitory(id) ON DELETE CASCADE
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT = '学生表';

-- 系统管理员
CREATE TABLE manager (
  id INT AUTO_INCREMENT PRIMARY KEY COMMENT '唯一标识一个管理员的ID号',
  name VARCHAR(20) NOT NULL COMMENT '管理员的登录账号',
  password VARCHAR(50) NOT NULL COMMENT '管理员登录的密码',
  born_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '管理员被创建的时间',
  update_time TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '管理员信息最后一次被修改的时间',
  permission INT(1) NOT NULL DEFAULT 1 COMMENT '管理员的权限：0表示超级管理员，1表示普通管理员'
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT = '管理员';

-- 宿舍
CREATE TABLE dormitory (
  id INT AUTO_INCREMENT PRIMARY KEY COMMENT '唯一标识一个宿舍的ID号',
  name VARCHAR(20) NOT NULL COMMENT '宿舍的编号',
  build VARCHAR(20) NOT NULL COMMENT '楼号',
  floor VARCHAR(20) NOT NULL COMMENT '楼层',
  room VARCHAR(20) NOT NULL COMMENT '房间号',
  type INT(1) NOT NULL DEFAULT 0 COMMENT '宿舍的类型：0表示男寝；1表示女寝；2表示留学生宿舍；3表示研究生宿舍'
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT = '宿舍';

-- 用电账户表
CREATE TABLE electricity_account (
  id INT AUTO_INCREMENT PRIMARY KEY COMMENT '唯一标识一个用电账户的ID号',
  dormitory_id INT COMMENT '账户对应的宿舍ID，系统默认为每一个宿舍分配一个用电账户',
  born_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '账户被创建的时间',
  update_time TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '账户信息最后一次被修改的时间',
  balance DOUBLE NOT NULL DEFAULT 0.0 COMMENT '账户剩余金额',
  remainingBattery DOUBLE NOT NULL DEFAULT 0.0 COMMENT '账户剩余电量',
  -- 级联宿舍，当宿舍被删除时，对应的账户也会被删除
  FOREIGN KEY(dormitory_id) REFERENCES dormitory(id) ON DELETE CASCADE
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT = '用电账户';

-- 用电情况
CREATE TABLE electricity_situation (
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '唯一标识一条用电情况的ID号',
  dormitory_id INT COMMENT '哪个宿舍的用电情况',
  bornTime TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '用电发生的时间，格式为yyyy-MM-dd',
  time_solt_id INT COMMENT '用电所发生的时间段',
  used_count DOUBLE NOT NULL COMMENT '用电量',
  -- 级联宿舍，当宿舍被删除时，对应的用电情况也会被删除
  FOREIGN KEY(dormitory_id) REFERENCES dormitory(id) ON DELETE CASCADE,
  FOREIGN KEY(time_solt_id) REFERENCES time_solt(id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT = '用电账户';

-- 系统划分的时间段
-- 该张表的记录不允许被删除，只允许添加
CREATE TABLE time_solt(
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '唯一标识一个时间段的ID号',
  name VARCHAR(20) NOT NULL COMMENT '时间段的名字标识',
  begin_time VARCHAR(20) NOT NULL COMMENT '一天中开始的时间,时间格式为 HH:mm:ss',
  end_time VARCHAR(20) NOT NULL COMMENT '一天中结束的时间，时间格式为 HH:mm:ss'
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT = '系统划分的时间段';

-- 系统通知表
CREATE TABLE notice (
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '唯一标识一条通知的ID号',
  born_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '系统通知被创建的时间',
  update_time TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '系统通知最后一次被修改的时间',
  title VARCHAR(50) NOT NULL COMMENT '系统通知的标题',
  content TEXT COMMENT '系统通知的内容',
  manager_id INT COMMENT '发布通知的管理员ID',
  FOREIGN KEY(manager_id) REFERENCES manager(id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT = '系统通知';

-- 电费订单
CREATE TABLE payment (
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '唯一标识一条电费订单的ID号',
  dormitory_id INT COMMENT '给哪一个宿舍充值',
  payment_count DOUBLE NOT NULL DEFAULT 0.0 COMMENT '给宿舍充值的金额',
  price DOUBLE NOT NULL DEFAULT 0.0 COMMENT '电费的单价',/*TODO*/
  battery_count DOUBLE NOT NULL DEFAULT 0.0 COMMENT '充值的电量',
  student_id BIGINT COMMENT '充值的主体学生ID号',
  FOREIGN KEY(dormitory_id) REFERENCES dormitory(id) ON DELETE CASCADE,
  FOREIGN KEY(student_id) REFERENCES student(id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT = '电费订单';

-- -----------------------------------------
-- end
-- version:1.0.0
-- author:huangting
-- description:该数据库用于支撑用电管理系统
-- time:2017/6/19
-- -----------------------------------------


















