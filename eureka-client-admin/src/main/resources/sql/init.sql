SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_city`
-- ----------------------------
DROP TABLE IF EXISTS `sys_city`;
CREATE TABLE `sys_city` (
  `code` varchar(20) NOT NULL COMMENT '市代码',
  `name` varchar(50) NOT NULL COMMENT '市名',
  `province_code` varchar(20) NOT NULL COMMENT '省代码',
  PRIMARY KEY (`code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='中国市表';

-- ----------------------------
-- Records of sys_city
-- ----------------------------
INSERT INTO `sys_city` VALUES ('1', '北京市', '1');
INSERT INTO `sys_city` VALUES ('2', '天津市', '2');
INSERT INTO `sys_city` VALUES ('3', '石家庄市', '3');
INSERT INTO `sys_city` VALUES ('4', '唐山市', '3');
INSERT INTO `sys_city` VALUES ('5', '秦皇岛市', '3');
INSERT INTO `sys_city` VALUES ('6', '邯郸市', '3');
INSERT INTO `sys_city` VALUES ('7', '邢台市', '3');
INSERT INTO `sys_city` VALUES ('8', '保定市', '3');
INSERT INTO `sys_city` VALUES ('9', '张家口市', '3');
INSERT INTO `sys_city` VALUES ('10', '承德市', '3');
INSERT INTO `sys_city` VALUES ('11', '沧州市', '3');
INSERT INTO `sys_city` VALUES ('12', '廊坊市', '3');
INSERT INTO `sys_city` VALUES ('13', '衡水市', '3');
INSERT INTO `sys_city` VALUES ('14', '太原市', '4');
INSERT INTO `sys_city` VALUES ('15', '大同市', '4');
INSERT INTO `sys_city` VALUES ('16', '阳泉市', '4');
INSERT INTO `sys_city` VALUES ('17', '长治市', '4');
INSERT INTO `sys_city` VALUES ('18', '晋城市', '4');
INSERT INTO `sys_city` VALUES ('19', '朔州市', '4');
INSERT INTO `sys_city` VALUES ('20', '晋中市', '4');
INSERT INTO `sys_city` VALUES ('21', '运城市', '4');
INSERT INTO `sys_city` VALUES ('22', '忻州市', '4');
INSERT INTO `sys_city` VALUES ('23', '临汾市', '4');
INSERT INTO `sys_city` VALUES ('24', '吕梁市', '4');
INSERT INTO `sys_city` VALUES ('25', '呼和浩特市', '5');
INSERT INTO `sys_city` VALUES ('26', '包头市', '5');
INSERT INTO `sys_city` VALUES ('27', '乌海市', '5');
INSERT INTO `sys_city` VALUES ('28', '赤峰市', '5');
INSERT INTO `sys_city` VALUES ('29', '通辽市', '5');
INSERT INTO `sys_city` VALUES ('30', '鄂尔多斯市', '5');
INSERT INTO `sys_city` VALUES ('31', '呼伦贝尔市', '5');
INSERT INTO `sys_city` VALUES ('32', '巴彦淖尔市', '5');
INSERT INTO `sys_city` VALUES ('33', '乌兰察布市', '5');
INSERT INTO `sys_city` VALUES ('34', '兴安盟', '5');
INSERT INTO `sys_city` VALUES ('35', '锡林郭勒盟', '5');
INSERT INTO `sys_city` VALUES ('36', '阿拉善盟', '5');
INSERT INTO `sys_city` VALUES ('37', '沈阳市', '6');
INSERT INTO `sys_city` VALUES ('38', '大连市', '6');
INSERT INTO `sys_city` VALUES ('39', '鞍山市', '6');
INSERT INTO `sys_city` VALUES ('40', '抚顺市', '6');
INSERT INTO `sys_city` VALUES ('41', '本溪市', '6');
INSERT INTO `sys_city` VALUES ('42', '丹东市', '6');
INSERT INTO `sys_city` VALUES ('43', '锦州市', '6');
INSERT INTO `sys_city` VALUES ('44', '营口市', '6');
INSERT INTO `sys_city` VALUES ('45', '阜新市', '6');
INSERT INTO `sys_city` VALUES ('46', '辽阳市', '6');
INSERT INTO `sys_city` VALUES ('47', '盘锦市', '6');
INSERT INTO `sys_city` VALUES ('48', '铁岭市', '6');
INSERT INTO `sys_city` VALUES ('49', '朝阳市', '6');
INSERT INTO `sys_city` VALUES ('50', '葫芦岛市', '6');
INSERT INTO `sys_city` VALUES ('51', '长春市', '7');
INSERT INTO `sys_city` VALUES ('52', '吉林市', '7');
INSERT INTO `sys_city` VALUES ('53', '四平市', '7');
INSERT INTO `sys_city` VALUES ('54', '辽源市', '7');
INSERT INTO `sys_city` VALUES ('55', '通化市', '7');
INSERT INTO `sys_city` VALUES ('56', '白山市', '7');
INSERT INTO `sys_city` VALUES ('57', '松原市', '7');
INSERT INTO `sys_city` VALUES ('58', '白城市', '7');
INSERT INTO `sys_city` VALUES ('59', '延边朝鲜族自治州', '7');
INSERT INTO `sys_city` VALUES ('60', '哈尔滨市', '8');
INSERT INTO `sys_city` VALUES ('61', '齐齐哈尔市', '8');
INSERT INTO `sys_city` VALUES ('62', '鸡西市', '8');
INSERT INTO `sys_city` VALUES ('63', '鹤岗市', '8');
INSERT INTO `sys_city` VALUES ('64', '双鸭山市', '8');
INSERT INTO `sys_city` VALUES ('65', '大庆市', '8');
INSERT INTO `sys_city` VALUES ('66', '伊春市', '8');
INSERT INTO `sys_city` VALUES ('67', '佳木斯市', '8');
INSERT INTO `sys_city` VALUES ('68', '七台河市', '8');
INSERT INTO `sys_city` VALUES ('69', '牡丹江市', '8');
INSERT INTO `sys_city` VALUES ('70', '黑河市', '8');
INSERT INTO `sys_city` VALUES ('71', '绥化市', '8');
INSERT INTO `sys_city` VALUES ('72', '大兴安岭地区', '8');
INSERT INTO `sys_city` VALUES ('73', '上海市', '9');
INSERT INTO `sys_city` VALUES ('74', '南京市', '10');
INSERT INTO `sys_city` VALUES ('75', '无锡市', '10');
INSERT INTO `sys_city` VALUES ('76', '徐州市', '10');
INSERT INTO `sys_city` VALUES ('77', '常州市', '10');
INSERT INTO `sys_city` VALUES ('78', '苏州市', '10');
INSERT INTO `sys_city` VALUES ('79', '南通市', '10');
INSERT INTO `sys_city` VALUES ('80', '连云港市', '10');
INSERT INTO `sys_city` VALUES ('81', '淮安市', '10');
INSERT INTO `sys_city` VALUES ('82', '盐城市', '10');
INSERT INTO `sys_city` VALUES ('83', '扬州市', '10');
INSERT INTO `sys_city` VALUES ('84', '镇江市', '10');
INSERT INTO `sys_city` VALUES ('85', '泰州市', '10');
INSERT INTO `sys_city` VALUES ('86', '宿迁市', '10');
INSERT INTO `sys_city` VALUES ('87', '杭州市', '11');
INSERT INTO `sys_city` VALUES ('88', '宁波市', '11');
INSERT INTO `sys_city` VALUES ('89', '温州市', '11');
INSERT INTO `sys_city` VALUES ('90', '嘉兴市', '11');
INSERT INTO `sys_city` VALUES ('91', '湖州市', '11');
INSERT INTO `sys_city` VALUES ('92', '绍兴市', '11');
INSERT INTO `sys_city` VALUES ('93', '金华市', '11');
INSERT INTO `sys_city` VALUES ('94', '衢州市', '11');
INSERT INTO `sys_city` VALUES ('95', '舟山市', '11');
INSERT INTO `sys_city` VALUES ('96', '台州市', '11');
INSERT INTO `sys_city` VALUES ('97', '丽水市', '11');
INSERT INTO `sys_city` VALUES ('98', '合肥市', '12');
INSERT INTO `sys_city` VALUES ('99', '芜湖市', '12');
INSERT INTO `sys_city` VALUES ('100', '蚌埠市', '12');
INSERT INTO `sys_city` VALUES ('101', '淮南市', '12');
INSERT INTO `sys_city` VALUES ('102', '马鞍山市', '12');
INSERT INTO `sys_city` VALUES ('103', '淮北市', '12');
INSERT INTO `sys_city` VALUES ('104', '铜陵市', '12');
INSERT INTO `sys_city` VALUES ('105', '安庆市', '12');
INSERT INTO `sys_city` VALUES ('106', '黄山市', '12');
INSERT INTO `sys_city` VALUES ('107', '滁州市', '12');
INSERT INTO `sys_city` VALUES ('108', '阜阳市', '12');
INSERT INTO `sys_city` VALUES ('109', '宿州市', '12');
INSERT INTO `sys_city` VALUES ('110', '巢湖市', '12');
INSERT INTO `sys_city` VALUES ('111', '六安市', '12');
INSERT INTO `sys_city` VALUES ('112', '亳州市', '12');
INSERT INTO `sys_city` VALUES ('113', '池州市', '12');
INSERT INTO `sys_city` VALUES ('114', '宣城市', '12');
INSERT INTO `sys_city` VALUES ('115', '福州市', '13');
INSERT INTO `sys_city` VALUES ('116', '厦门市', '13');
INSERT INTO `sys_city` VALUES ('117', '莆田市', '13');
INSERT INTO `sys_city` VALUES ('118', '三明市', '13');
INSERT INTO `sys_city` VALUES ('119', '泉州市', '13');
INSERT INTO `sys_city` VALUES ('120', '漳州市', '13');
INSERT INTO `sys_city` VALUES ('121', '南平市', '13');
INSERT INTO `sys_city` VALUES ('122', '龙岩市', '13');
INSERT INTO `sys_city` VALUES ('123', '宁德市', '13');
INSERT INTO `sys_city` VALUES ('124', '南昌市', '14');
INSERT INTO `sys_city` VALUES ('125', '景德镇市', '14');
INSERT INTO `sys_city` VALUES ('126', '萍乡市', '14');
INSERT INTO `sys_city` VALUES ('127', '九江市', '14');
INSERT INTO `sys_city` VALUES ('128', '新余市', '14');
INSERT INTO `sys_city` VALUES ('129', '鹰潭市', '14');
INSERT INTO `sys_city` VALUES ('130', '赣州市', '14');
INSERT INTO `sys_city` VALUES ('131', '吉安市', '14');
INSERT INTO `sys_city` VALUES ('132', '宜春市', '14');
INSERT INTO `sys_city` VALUES ('133', '抚州市', '14');
INSERT INTO `sys_city` VALUES ('134', '上饶市', '14');
INSERT INTO `sys_city` VALUES ('135', '济南市', '15');
INSERT INTO `sys_city` VALUES ('136', '青岛市', '15');
INSERT INTO `sys_city` VALUES ('137', '淄博市', '15');
INSERT INTO `sys_city` VALUES ('138', '枣庄市', '15');
INSERT INTO `sys_city` VALUES ('139', '东营市', '15');
INSERT INTO `sys_city` VALUES ('140', '烟台市', '15');
INSERT INTO `sys_city` VALUES ('141', '潍坊市', '15');
INSERT INTO `sys_city` VALUES ('142', '济宁市', '15');
INSERT INTO `sys_city` VALUES ('143', '泰安市', '15');
INSERT INTO `sys_city` VALUES ('144', '威海市', '15');
INSERT INTO `sys_city` VALUES ('145', '日照市', '15');
INSERT INTO `sys_city` VALUES ('146', '莱芜市', '15');
INSERT INTO `sys_city` VALUES ('147', '临沂市', '15');
INSERT INTO `sys_city` VALUES ('148', '德州市', '15');
INSERT INTO `sys_city` VALUES ('149', '聊城市', '15');
INSERT INTO `sys_city` VALUES ('150', '滨州市', '15');
INSERT INTO `sys_city` VALUES ('151', '荷泽市', '15');
INSERT INTO `sys_city` VALUES ('152', '郑州市', '16');
INSERT INTO `sys_city` VALUES ('153', '开封市', '16');
INSERT INTO `sys_city` VALUES ('154', '洛阳市', '16');
INSERT INTO `sys_city` VALUES ('155', '平顶山市', '16');
INSERT INTO `sys_city` VALUES ('156', '安阳市', '16');
INSERT INTO `sys_city` VALUES ('157', '鹤壁市', '16');
INSERT INTO `sys_city` VALUES ('158', '新乡市', '16');
INSERT INTO `sys_city` VALUES ('159', '焦作市', '16');
INSERT INTO `sys_city` VALUES ('160', '濮阳市', '16');
INSERT INTO `sys_city` VALUES ('161', '许昌市', '16');
INSERT INTO `sys_city` VALUES ('162', '漯河市', '16');
INSERT INTO `sys_city` VALUES ('163', '三门峡市', '16');
INSERT INTO `sys_city` VALUES ('164', '南阳市', '16');
INSERT INTO `sys_city` VALUES ('165', '商丘市', '16');
INSERT INTO `sys_city` VALUES ('166', '信阳市', '16');
INSERT INTO `sys_city` VALUES ('167', '周口市', '16');
INSERT INTO `sys_city` VALUES ('168', '驻马店市', '16');
INSERT INTO `sys_city` VALUES ('169', '武汉市', '17');
INSERT INTO `sys_city` VALUES ('170', '黄石市', '17');
INSERT INTO `sys_city` VALUES ('171', '十堰市', '17');
INSERT INTO `sys_city` VALUES ('172', '宜昌市', '17');
INSERT INTO `sys_city` VALUES ('173', '襄樊市', '17');
INSERT INTO `sys_city` VALUES ('174', '鄂州市', '17');
INSERT INTO `sys_city` VALUES ('175', '荆门市', '17');
INSERT INTO `sys_city` VALUES ('176', '孝感市', '17');
INSERT INTO `sys_city` VALUES ('177', '荆州市', '17');
INSERT INTO `sys_city` VALUES ('178', '黄冈市', '17');
INSERT INTO `sys_city` VALUES ('179', '咸宁市', '17');
INSERT INTO `sys_city` VALUES ('180', '随州市', '17');
INSERT INTO `sys_city` VALUES ('181', '恩施土家族苗族自治州', '17');
INSERT INTO `sys_city` VALUES ('182', '神农架', '17');
INSERT INTO `sys_city` VALUES ('183', '长沙市', '18');
INSERT INTO `sys_city` VALUES ('184', '株洲市', '18');
INSERT INTO `sys_city` VALUES ('185', '湘潭市', '18');
INSERT INTO `sys_city` VALUES ('186', '衡阳市', '18');
INSERT INTO `sys_city` VALUES ('187', '邵阳市', '18');
INSERT INTO `sys_city` VALUES ('188', '岳阳市', '18');
INSERT INTO `sys_city` VALUES ('189', '常德市', '18');
INSERT INTO `sys_city` VALUES ('190', '张家界市', '18');
INSERT INTO `sys_city` VALUES ('191', '益阳市', '18');
INSERT INTO `sys_city` VALUES ('192', '郴州市', '18');
INSERT INTO `sys_city` VALUES ('193', '永州市', '18');
INSERT INTO `sys_city` VALUES ('194', '怀化市', '18');
INSERT INTO `sys_city` VALUES ('195', '娄底市', '18');
INSERT INTO `sys_city` VALUES ('196', '湘西土家族苗族自治州', '18');
INSERT INTO `sys_city` VALUES ('197', '广州市', '19');
INSERT INTO `sys_city` VALUES ('198', '韶关市', '19');
INSERT INTO `sys_city` VALUES ('199', '深圳市', '19');
INSERT INTO `sys_city` VALUES ('200', '珠海市', '19');
INSERT INTO `sys_city` VALUES ('201', '汕头市', '19');
INSERT INTO `sys_city` VALUES ('202', '佛山市', '19');
INSERT INTO `sys_city` VALUES ('203', '江门市', '19');
INSERT INTO `sys_city` VALUES ('204', '湛江市', '19');
INSERT INTO `sys_city` VALUES ('205', '茂名市', '19');
INSERT INTO `sys_city` VALUES ('206', '肇庆市', '19');
INSERT INTO `sys_city` VALUES ('207', '惠州市', '19');
INSERT INTO `sys_city` VALUES ('208', '梅州市', '19');
INSERT INTO `sys_city` VALUES ('209', '汕尾市', '19');
INSERT INTO `sys_city` VALUES ('210', '河源市', '19');
INSERT INTO `sys_city` VALUES ('211', '阳江市', '19');
INSERT INTO `sys_city` VALUES ('212', '清远市', '19');
INSERT INTO `sys_city` VALUES ('213', '东莞市', '19');
INSERT INTO `sys_city` VALUES ('214', '中山市', '19');
INSERT INTO `sys_city` VALUES ('215', '潮州市', '19');
INSERT INTO `sys_city` VALUES ('216', '揭阳市', '19');
INSERT INTO `sys_city` VALUES ('217', '云浮市', '19');
INSERT INTO `sys_city` VALUES ('218', '南宁市', '20');
INSERT INTO `sys_city` VALUES ('219', '柳州市', '20');
INSERT INTO `sys_city` VALUES ('220', '桂林市', '20');
INSERT INTO `sys_city` VALUES ('221', '梧州市', '20');
INSERT INTO `sys_city` VALUES ('222', '北海市', '20');
INSERT INTO `sys_city` VALUES ('223', '防城港市', '20');
INSERT INTO `sys_city` VALUES ('224', '钦州市', '20');
INSERT INTO `sys_city` VALUES ('225', '贵港市', '20');
INSERT INTO `sys_city` VALUES ('226', '玉林市', '20');
INSERT INTO `sys_city` VALUES ('227', '百色市', '20');
INSERT INTO `sys_city` VALUES ('228', '贺州市', '20');
INSERT INTO `sys_city` VALUES ('229', '河池市', '20');
INSERT INTO `sys_city` VALUES ('230', '来宾市', '20');
INSERT INTO `sys_city` VALUES ('231', '崇左市', '20');
INSERT INTO `sys_city` VALUES ('232', '海口市', '21');
INSERT INTO `sys_city` VALUES ('233', '三亚市', '21');
INSERT INTO `sys_city` VALUES ('234', '重庆市', '22');
INSERT INTO `sys_city` VALUES ('235', '成都市', '23');
INSERT INTO `sys_city` VALUES ('236', '自贡市', '23');
INSERT INTO `sys_city` VALUES ('237', '攀枝花市', '23');
INSERT INTO `sys_city` VALUES ('238', '泸州市', '23');
INSERT INTO `sys_city` VALUES ('239', '德阳市', '23');
INSERT INTO `sys_city` VALUES ('240', '绵阳市', '23');
INSERT INTO `sys_city` VALUES ('241', '广元市', '23');
INSERT INTO `sys_city` VALUES ('242', '遂宁市', '23');
INSERT INTO `sys_city` VALUES ('243', '内江市', '23');
INSERT INTO `sys_city` VALUES ('244', '乐山市', '23');
INSERT INTO `sys_city` VALUES ('245', '南充市', '23');
INSERT INTO `sys_city` VALUES ('246', '眉山市', '23');
INSERT INTO `sys_city` VALUES ('247', '宜宾市', '23');
INSERT INTO `sys_city` VALUES ('248', '广安市', '23');
INSERT INTO `sys_city` VALUES ('249', '达州市', '23');
INSERT INTO `sys_city` VALUES ('250', '雅安市', '23');
INSERT INTO `sys_city` VALUES ('251', '巴中市', '23');
INSERT INTO `sys_city` VALUES ('252', '资阳市', '23');
INSERT INTO `sys_city` VALUES ('253', '阿坝藏族羌族自治州', '23');
INSERT INTO `sys_city` VALUES ('254', '甘孜藏族自治州', '23');
INSERT INTO `sys_city` VALUES ('255', '凉山彝族自治州', '23');
INSERT INTO `sys_city` VALUES ('256', '贵阳市', '24');
INSERT INTO `sys_city` VALUES ('257', '六盘水市', '24');
INSERT INTO `sys_city` VALUES ('258', '遵义市', '24');
INSERT INTO `sys_city` VALUES ('259', '安顺市', '24');
INSERT INTO `sys_city` VALUES ('260', '铜仁地区', '24');
INSERT INTO `sys_city` VALUES ('261', '黔西南布依族苗族自治州', '24');
INSERT INTO `sys_city` VALUES ('262', '毕节地区', '24');
INSERT INTO `sys_city` VALUES ('263', '黔东南苗族侗族自治州', '24');
INSERT INTO `sys_city` VALUES ('264', '黔南布依族苗族自治州', '24');
INSERT INTO `sys_city` VALUES ('265', '昆明市', '25');
INSERT INTO `sys_city` VALUES ('266', '曲靖市', '25');
INSERT INTO `sys_city` VALUES ('267', '玉溪市', '25');
INSERT INTO `sys_city` VALUES ('268', '保山市', '25');
INSERT INTO `sys_city` VALUES ('269', '昭通市', '25');
INSERT INTO `sys_city` VALUES ('270', '丽江市', '25');
INSERT INTO `sys_city` VALUES ('271', '思茅市', '25');
INSERT INTO `sys_city` VALUES ('272', '临沧市', '25');
INSERT INTO `sys_city` VALUES ('273', '楚雄彝族自治州', '25');
INSERT INTO `sys_city` VALUES ('274', '红河哈尼族彝族自治州', '25');
INSERT INTO `sys_city` VALUES ('275', '文山壮族苗族自治州', '25');
INSERT INTO `sys_city` VALUES ('276', '西双版纳傣族自治州', '25');
INSERT INTO `sys_city` VALUES ('277', '大理白族自治州', '25');
INSERT INTO `sys_city` VALUES ('278', '德宏傣族景颇族自治州', '25');
INSERT INTO `sys_city` VALUES ('279', '怒江傈僳族自治州', '25');
INSERT INTO `sys_city` VALUES ('280', '迪庆藏族自治州', '25');
INSERT INTO `sys_city` VALUES ('281', '拉萨市', '26');
INSERT INTO `sys_city` VALUES ('282', '昌都地区', '26');
INSERT INTO `sys_city` VALUES ('283', '山南地区', '26');
INSERT INTO `sys_city` VALUES ('284', '日喀则地区', '26');
INSERT INTO `sys_city` VALUES ('285', '那曲地区', '26');
INSERT INTO `sys_city` VALUES ('286', '阿里地区', '26');
INSERT INTO `sys_city` VALUES ('287', '林芝地区', '26');
INSERT INTO `sys_city` VALUES ('288', '西安市', '27');
INSERT INTO `sys_city` VALUES ('289', '铜川市', '27');
INSERT INTO `sys_city` VALUES ('290', '宝鸡市', '27');
INSERT INTO `sys_city` VALUES ('291', '咸阳市', '27');
INSERT INTO `sys_city` VALUES ('292', '渭南市', '27');
INSERT INTO `sys_city` VALUES ('293', '延安市', '27');
INSERT INTO `sys_city` VALUES ('294', '汉中市', '27');
INSERT INTO `sys_city` VALUES ('295', '榆林市', '27');
INSERT INTO `sys_city` VALUES ('296', '安康市', '27');
INSERT INTO `sys_city` VALUES ('297', '商洛市', '27');
INSERT INTO `sys_city` VALUES ('298', '兰州市', '28');
INSERT INTO `sys_city` VALUES ('299', '嘉峪关市', '28');
INSERT INTO `sys_city` VALUES ('300', '金昌市', '28');
INSERT INTO `sys_city` VALUES ('301', '白银市', '28');
INSERT INTO `sys_city` VALUES ('302', '天水市', '28');
INSERT INTO `sys_city` VALUES ('303', '武威市', '28');
INSERT INTO `sys_city` VALUES ('304', '张掖市', '28');
INSERT INTO `sys_city` VALUES ('305', '平凉市', '28');
INSERT INTO `sys_city` VALUES ('306', '酒泉市', '28');
INSERT INTO `sys_city` VALUES ('307', '庆阳市', '28');
INSERT INTO `sys_city` VALUES ('308', '定西市', '28');
INSERT INTO `sys_city` VALUES ('309', '陇南市', '28');
INSERT INTO `sys_city` VALUES ('310', '临夏回族自治州', '28');
INSERT INTO `sys_city` VALUES ('311', '甘南藏族自治州', '28');
INSERT INTO `sys_city` VALUES ('312', '西宁市', '29');
INSERT INTO `sys_city` VALUES ('313', '海东地区', '29');
INSERT INTO `sys_city` VALUES ('314', '海北藏族自治州', '29');
INSERT INTO `sys_city` VALUES ('315', '黄南藏族自治州', '29');
INSERT INTO `sys_city` VALUES ('316', '海南藏族自治州', '29');
INSERT INTO `sys_city` VALUES ('317', '果洛藏族自治州', '29');
INSERT INTO `sys_city` VALUES ('318', '玉树藏族自治州', '29');
INSERT INTO `sys_city` VALUES ('319', '海西蒙古族藏族自治州', '29');
INSERT INTO `sys_city` VALUES ('320', '银川市', '30');
INSERT INTO `sys_city` VALUES ('321', '石嘴山市', '30');
INSERT INTO `sys_city` VALUES ('322', '吴忠市', '30');
INSERT INTO `sys_city` VALUES ('323', '固原市', '30');
INSERT INTO `sys_city` VALUES ('324', '中卫市', '30');
INSERT INTO `sys_city` VALUES ('325', '乌鲁木齐市', '31');
INSERT INTO `sys_city` VALUES ('326', '克拉玛依市', '31');
INSERT INTO `sys_city` VALUES ('327', '吐鲁番地区', '31');
INSERT INTO `sys_city` VALUES ('328', '哈密地区', '31');
INSERT INTO `sys_city` VALUES ('329', '昌吉回族自治州', '31');
INSERT INTO `sys_city` VALUES ('330', '博尔塔拉蒙古自治州', '31');
INSERT INTO `sys_city` VALUES ('331', '巴音郭楞蒙古自治州', '31');
INSERT INTO `sys_city` VALUES ('332', '阿克苏地区', '31');
INSERT INTO `sys_city` VALUES ('333', '克孜勒苏柯尔克孜自治州', '31');
INSERT INTO `sys_city` VALUES ('334', '喀什地区', '31');
INSERT INTO `sys_city` VALUES ('335', '和田地区', '31');
INSERT INTO `sys_city` VALUES ('336', '伊犁哈萨克自治州', '31');
INSERT INTO `sys_city` VALUES ('337', '塔城地区', '31');
INSERT INTO `sys_city` VALUES ('338', '阿勒泰地区', '31');
INSERT INTO `sys_city` VALUES ('339', '石河子市', '31');
INSERT INTO `sys_city` VALUES ('340', '阿拉尔市', '31');
INSERT INTO `sys_city` VALUES ('341', '图木舒克市', '31');
INSERT INTO `sys_city` VALUES ('342', '五家渠市', '31');
INSERT INTO `sys_city` VALUES ('343', '香港特别行政区', '32');
INSERT INTO `sys_city` VALUES ('344', '澳门特别行政区', '33');
INSERT INTO `sys_city` VALUES ('345', '台湾省', '34');

-- ----------------------------
-- Table structure for `sys_config`
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `id` varchar(255) NOT NULL COMMENT '主键ID',
  `data_type` varchar(255) DEFAULT NULL COMMENT '数据类型',
  `key_code` varchar(255) DEFAULT NULL COMMENT 'key值',
  `value_code` varchar(255) DEFAULT NULL COMMENT 'value值',
  `category_name` varchar(255) DEFAULT NULL COMMENT '分类名称',
  `category_code` varchar(255) DEFAULT NULL COMMENT '分类代码',
  `sort` int(11) DEFAULT NULL COMMENT '序号',
  `means` varchar(255) DEFAULT NULL COMMENT '含义',
  `universally` tinyint(4) DEFAULT NULL COMMENT '是否通用(0:通用;1:不通用)',
  `system_id` varchar(255) DEFAULT NULL COMMENT '系统ID',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注说明',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(255) DEFAULT NULL COMMENT '创建者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新者',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '删除标记(0:未被删除;1:已被删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统配置表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('202111090856359351', 'password', 'init.user.password', 'abcd1234', '密码', 'password', '1', '初始化密码', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');
INSERT INTO `sys_config` VALUES ('202111090856359421', 'file_root_path', 'file.root.linux.path', '/tmp/file/', '文件路径', 'fileRootPath', '2', '文件根路径（linux）', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');
INSERT INTO `sys_config` VALUES ('202111090856359441', 'file_root_path', 'file.root.windows.path', 'E:/file/', '文件路径', 'fileRootPath', '2', '文件根路径（windows）', '0', null, '最好用/因为java是跨平台的。\\（在java代码里应该是\\\\）是windows环境下的路径分隔符，Linux和Unix下都是用/。而在windows下也能识别/。所以最好用/', '2021-02-19 16:15:44', '-1', null, null, '0');
INSERT INTO `sys_config` VALUES ('202111090856359451', 'repeat_login', 'repeat.login.handle', '1', '重复登录处理', 'repeatLogin', '3', '重复登录处理（1：允许重复登录；2：不允许重复登录）', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');

-- ----------------------------
-- Table structure for `sys_data_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_data_permission`;
CREATE TABLE `sys_data_permission` (
  `id` varchar(255) NOT NULL COMMENT '主键ID',
  `exclude_field` varchar(1000) NOT NULL COMMENT '排除字段',
  `interfaces_id` varchar(255) NOT NULL COMMENT '接口ID',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注说明',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(255) DEFAULT NULL COMMENT '创建者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新者',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '删除标记(0:未被删除;1:已被删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统数据权限表';

-- ----------------------------
-- Records of sys_data_permission
-- ----------------------------
INSERT INTO `sys_data_permission` VALUES ('202201031117498851', 'userName', '202005161425051821', null, '2022-01-03 11:17:49', '-1', null, null, '0');

-- ----------------------------
-- Table structure for `sys_dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary`;
CREATE TABLE `sys_dictionary` (
  `id` varchar(255) NOT NULL COMMENT '主键ID',
  `parent_id` varchar(255) DEFAULT NULL COMMENT '父ID',
  `fcode` varchar(255) DEFAULT NULL COMMENT '层级关系',
  `level` int(11) DEFAULT NULL COMMENT '第几级(0表示未定义层级数;层级数1为最高,即根节点)',
  `data_type` varchar(255) DEFAULT NULL COMMENT '数据类型',
  `key_code` varchar(255) DEFAULT NULL COMMENT 'key值',
  `value_code` varchar(255) DEFAULT NULL COMMENT 'value值',
  `category_name` varchar(255) DEFAULT NULL COMMENT '分类名称',
  `category_code` varchar(255) DEFAULT NULL COMMENT '分类代码',
  `sort` int(11) DEFAULT NULL COMMENT '序号',
  `means` varchar(255) DEFAULT NULL COMMENT '含义',
  `universally` tinyint(4) DEFAULT NULL COMMENT '是否通用(0:通用;1:不通用)',
  `system_id` varchar(255) DEFAULT NULL COMMENT '系统ID',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注说明',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(255) DEFAULT NULL COMMENT '创建者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新者',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '删除标记(0:未被删除;1:已被删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统字典表';

-- ----------------------------
-- Records of sys_dictionary
-- ----------------------------
INSERT INTO `sys_dictionary` VALUES ('202003282118348411', null, null, '0', 'del_flag', 'undelete', '0', '删除标记', 'delFlag', '1', '未删除', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('202003282118348471', null, null, '0', 'user_role_strategy', 'intersection', '2', '用户角色策略', 'userRoleStrategy', '3', '交集', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('202003282118348501', null, null, '0', 'user_role_strategy', 'union', '1', '用户角色策略', 'userRoleStrategy', '2', '并集', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('202003282118348541', null, null, '0', 'client_type', 'web', '1', '客户端类型', 'clientType', '2', '网页端', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('202003282118348571', null, null, '0', 'client_type', 'android', '2', '客户端类型', 'clientType', '3', '安卓端', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('202003282119121411', null, null, '0', 'module_type', 'catalogue', '1', '模块类型', 'moduleType', '1', '目录', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('202003282119121471', null, null, '0', 'module_type', 'function', '3', '模块类型', 'moduleType', '3', '功能', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('202003282119121511', null, null, '0', 'client_type', 'ios', '3', '客户端类型', 'clientType', '4', 'IOS端', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('202003282119121561', null, null, '0', 'user_role_strategy', 'basedOnRole', '4', '用户角色策略', 'userRoleStrategy', '5', '以角色权限为准', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('202003282119469071', null, null, '0', 'module_type', 'menu', '2', '模块类型', 'moduleType', '2', '菜单', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('202003282119469151', null, null, '0', 'del_flag', 'delete', '1', '删除标记', 'delFlag', '2', '删除', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('202003282119469221', null, null, '0', 'user_role_strategy', 'basedOnUser', '3', '用户角色策略', 'userRoleStrategy', '4', '以用户权限为准', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('202003282119469301', null, null, '0', 'user_role_strategy', 'customize', '0', '用户角色策略', 'userRoleStrategy', '1', '自定义', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('202005142045309912', null, null, '0', 'user_state', 'normal', '0', '用户状态', 'userState', '1', '正常', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('202005142045309913', null, null, '0', 'user_state', 'forbid', '1', '用户状态', 'userState', '2', '禁用', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('202102191610430681', null, null, '0', 'time_unit', 'year', '1', '时间单位', 'timeUnit', '1', '年', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('202102191610430682', null, null, '0', 'time_unit', 'month', '2', '时间单位', 'timeUnit', '2', '月', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('202102191610430683', null, null, '0', 'time_unit', 'day', '3', '时间单位', 'timeUnit', '3', '日', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('202102191610430684', null, null, '0', 'time_unit', 'hour', '4', '时间单位', 'timeUnit', '4', '时', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('202102191610430685', null, null, '0', 'time_unit', 'minute', '5', '时间单位', 'timeUnit', '5', '分', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('202102191610430686', null, null, '0', 'time_unit', 'second', '6', '时间单位', 'timeUnit', '6', '秒', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('202102191610430687', null, null, '0', 'role_restrict_way', 'personal', '1', '角色限定方式', 'roleRestrictWay', '1', '本人', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('202102191610430688', null, null, '0', 'role_restrict_way', 'unpersonal ', '2', '角色限定方式', 'roleRestrictWay', '2', '非本人', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('202201121735087271', null, null, '0', 'db_operate_type', 'select', '1', '数据库操作类型', 'dbOperateType', '1', '查询', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('202201121735087341', null, null, '0', 'db_operate_type', 'insert', '2', '数据库操作类型', 'dbOperateType', '2', '插入', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('202201121735087351', null, null, '0', 'db_operate_type', 'update', '3', '数据库操作类型', 'dbOperateType', '3', '修改', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');
INSERT INTO `sys_dictionary` VALUES ('202201121735087371', null, null, '0', 'db_operate_type', 'delete', '4', '数据库操作类型', 'dbOperateType', '4', '删除', '0', null, null, '2021-02-19 16:15:44', '-1', null, null, '0');

-- ----------------------------
-- Table structure for `sys_district`
-- ----------------------------
DROP TABLE IF EXISTS `sys_district`;
CREATE TABLE `sys_district` (
  `code` varchar(20) NOT NULL COMMENT '区代码',
  `name` varchar(50) NOT NULL COMMENT '区名',
  `city_code` varchar(20) NOT NULL COMMENT '市代码',
  PRIMARY KEY (`code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='中国区表';

-- ----------------------------
-- Records of sys_district
-- ----------------------------
INSERT INTO `sys_district` VALUES ('1', '东城区', '1');
INSERT INTO `sys_district` VALUES ('2', '西城区', '1');
INSERT INTO `sys_district` VALUES ('3', '崇文区', '1');
INSERT INTO `sys_district` VALUES ('4', '宣武区', '1');
INSERT INTO `sys_district` VALUES ('5', '朝阳区', '1');
INSERT INTO `sys_district` VALUES ('6', '丰台区', '1');
INSERT INTO `sys_district` VALUES ('7', '石景山区', '1');
INSERT INTO `sys_district` VALUES ('8', '海淀区', '1');
INSERT INTO `sys_district` VALUES ('9', '门头沟区', '1');
INSERT INTO `sys_district` VALUES ('10', '房山区', '1');
INSERT INTO `sys_district` VALUES ('11', '通州区', '1');
INSERT INTO `sys_district` VALUES ('12', '顺义区', '1');
INSERT INTO `sys_district` VALUES ('13', '昌平区', '1');
INSERT INTO `sys_district` VALUES ('14', '大兴区', '1');
INSERT INTO `sys_district` VALUES ('15', '怀柔区', '1');
INSERT INTO `sys_district` VALUES ('16', '平谷区', '1');
INSERT INTO `sys_district` VALUES ('17', '密云县', '1');
INSERT INTO `sys_district` VALUES ('18', '延庆县', '1');
INSERT INTO `sys_district` VALUES ('19', '和平区', '2');
INSERT INTO `sys_district` VALUES ('20', '河东区', '2');
INSERT INTO `sys_district` VALUES ('21', '河西区', '2');
INSERT INTO `sys_district` VALUES ('22', '南开区', '2');
INSERT INTO `sys_district` VALUES ('23', '河北区', '2');
INSERT INTO `sys_district` VALUES ('24', '红桥区', '2');
INSERT INTO `sys_district` VALUES ('25', '塘沽区', '2');
INSERT INTO `sys_district` VALUES ('26', '汉沽区', '2');
INSERT INTO `sys_district` VALUES ('27', '大港区', '2');
INSERT INTO `sys_district` VALUES ('28', '东丽区', '2');
INSERT INTO `sys_district` VALUES ('29', '西青区', '2');
INSERT INTO `sys_district` VALUES ('30', '津南区', '2');
INSERT INTO `sys_district` VALUES ('31', '北辰区', '2');
INSERT INTO `sys_district` VALUES ('32', '武清区', '2');
INSERT INTO `sys_district` VALUES ('33', '宝坻区', '2');
INSERT INTO `sys_district` VALUES ('34', '宁河县', '2');
INSERT INTO `sys_district` VALUES ('35', '静海县', '2');
INSERT INTO `sys_district` VALUES ('36', '蓟县', '2');
INSERT INTO `sys_district` VALUES ('37', '长安区', '3');
INSERT INTO `sys_district` VALUES ('38', '桥东区', '3');
INSERT INTO `sys_district` VALUES ('39', '桥西区', '3');
INSERT INTO `sys_district` VALUES ('40', '新华区', '3');
INSERT INTO `sys_district` VALUES ('41', '井陉矿区', '3');
INSERT INTO `sys_district` VALUES ('42', '裕华区', '3');
INSERT INTO `sys_district` VALUES ('43', '井陉县', '3');
INSERT INTO `sys_district` VALUES ('44', '正定县', '3');
INSERT INTO `sys_district` VALUES ('45', '栾城县', '3');
INSERT INTO `sys_district` VALUES ('46', '行唐县', '3');
INSERT INTO `sys_district` VALUES ('47', '灵寿县', '3');
INSERT INTO `sys_district` VALUES ('48', '高邑县', '3');
INSERT INTO `sys_district` VALUES ('49', '深泽县', '3');
INSERT INTO `sys_district` VALUES ('50', '赞皇县', '3');
INSERT INTO `sys_district` VALUES ('51', '无极县', '3');
INSERT INTO `sys_district` VALUES ('52', '平山县', '3');
INSERT INTO `sys_district` VALUES ('53', '元氏县', '3');
INSERT INTO `sys_district` VALUES ('54', '赵县', '3');
INSERT INTO `sys_district` VALUES ('55', '辛集市', '3');
INSERT INTO `sys_district` VALUES ('56', '藁城市', '3');
INSERT INTO `sys_district` VALUES ('57', '晋州市', '3');
INSERT INTO `sys_district` VALUES ('58', '新乐市', '3');
INSERT INTO `sys_district` VALUES ('59', '鹿泉市', '3');
INSERT INTO `sys_district` VALUES ('60', '路南区', '4');
INSERT INTO `sys_district` VALUES ('61', '路北区', '4');
INSERT INTO `sys_district` VALUES ('62', '古冶区', '4');
INSERT INTO `sys_district` VALUES ('63', '开平区', '4');
INSERT INTO `sys_district` VALUES ('64', '丰南区', '4');
INSERT INTO `sys_district` VALUES ('65', '丰润区', '4');
INSERT INTO `sys_district` VALUES ('66', '滦县', '4');
INSERT INTO `sys_district` VALUES ('67', '滦南县', '4');
INSERT INTO `sys_district` VALUES ('68', '乐亭县', '4');
INSERT INTO `sys_district` VALUES ('69', '迁西县', '4');
INSERT INTO `sys_district` VALUES ('70', '玉田县', '4');
INSERT INTO `sys_district` VALUES ('71', '唐海县', '4');
INSERT INTO `sys_district` VALUES ('72', '遵化市', '4');
INSERT INTO `sys_district` VALUES ('73', '迁安市', '4');
INSERT INTO `sys_district` VALUES ('74', '海港区', '5');
INSERT INTO `sys_district` VALUES ('75', '山海关区', '5');
INSERT INTO `sys_district` VALUES ('76', '北戴河区', '5');
INSERT INTO `sys_district` VALUES ('77', '青龙满族自治县', '5');
INSERT INTO `sys_district` VALUES ('78', '昌黎县', '5');
INSERT INTO `sys_district` VALUES ('79', '抚宁县', '5');
INSERT INTO `sys_district` VALUES ('80', '卢龙县', '5');
INSERT INTO `sys_district` VALUES ('81', '邯山区', '6');
INSERT INTO `sys_district` VALUES ('82', '丛台区', '6');
INSERT INTO `sys_district` VALUES ('83', '复兴区', '6');
INSERT INTO `sys_district` VALUES ('84', '峰峰矿区', '6');
INSERT INTO `sys_district` VALUES ('85', '邯郸县', '6');
INSERT INTO `sys_district` VALUES ('86', '临漳县', '6');
INSERT INTO `sys_district` VALUES ('87', '成安县', '6');
INSERT INTO `sys_district` VALUES ('88', '大名县', '6');
INSERT INTO `sys_district` VALUES ('89', '涉县', '6');
INSERT INTO `sys_district` VALUES ('90', '磁县', '6');
INSERT INTO `sys_district` VALUES ('91', '肥乡县', '6');
INSERT INTO `sys_district` VALUES ('92', '永年县', '6');
INSERT INTO `sys_district` VALUES ('93', '邱县', '6');
INSERT INTO `sys_district` VALUES ('94', '鸡泽县', '6');
INSERT INTO `sys_district` VALUES ('95', '广平县', '6');
INSERT INTO `sys_district` VALUES ('96', '馆陶县', '6');
INSERT INTO `sys_district` VALUES ('97', '魏县', '6');
INSERT INTO `sys_district` VALUES ('98', '曲周县', '6');
INSERT INTO `sys_district` VALUES ('99', '武安市', '6');
INSERT INTO `sys_district` VALUES ('100', '桥东区', '7');
INSERT INTO `sys_district` VALUES ('101', '桥西区', '7');
INSERT INTO `sys_district` VALUES ('102', '邢台县', '7');
INSERT INTO `sys_district` VALUES ('103', '临城县', '7');
INSERT INTO `sys_district` VALUES ('104', '内丘县', '7');
INSERT INTO `sys_district` VALUES ('105', '柏乡县', '7');
INSERT INTO `sys_district` VALUES ('106', '隆尧县', '7');
INSERT INTO `sys_district` VALUES ('107', '任县', '7');
INSERT INTO `sys_district` VALUES ('108', '南和县', '7');
INSERT INTO `sys_district` VALUES ('109', '宁晋县', '7');
INSERT INTO `sys_district` VALUES ('110', '巨鹿县', '7');
INSERT INTO `sys_district` VALUES ('111', '新河县', '7');
INSERT INTO `sys_district` VALUES ('112', '广宗县', '7');
INSERT INTO `sys_district` VALUES ('113', '平乡县', '7');
INSERT INTO `sys_district` VALUES ('114', '威县', '7');
INSERT INTO `sys_district` VALUES ('115', '清河县', '7');
INSERT INTO `sys_district` VALUES ('116', '临西县', '7');
INSERT INTO `sys_district` VALUES ('117', '南宫市', '7');
INSERT INTO `sys_district` VALUES ('118', '沙河市', '7');
INSERT INTO `sys_district` VALUES ('119', '新市区', '8');
INSERT INTO `sys_district` VALUES ('120', '北市区', '8');
INSERT INTO `sys_district` VALUES ('121', '南市区', '8');
INSERT INTO `sys_district` VALUES ('122', '满城县', '8');
INSERT INTO `sys_district` VALUES ('123', '清苑县', '8');
INSERT INTO `sys_district` VALUES ('124', '涞水县', '8');
INSERT INTO `sys_district` VALUES ('125', '阜平县', '8');
INSERT INTO `sys_district` VALUES ('126', '徐水县', '8');
INSERT INTO `sys_district` VALUES ('127', '定兴县', '8');
INSERT INTO `sys_district` VALUES ('128', '唐县', '8');
INSERT INTO `sys_district` VALUES ('129', '高阳县', '8');
INSERT INTO `sys_district` VALUES ('130', '容城县', '8');
INSERT INTO `sys_district` VALUES ('131', '涞源县', '8');
INSERT INTO `sys_district` VALUES ('132', '望都县', '8');
INSERT INTO `sys_district` VALUES ('133', '安新县', '8');
INSERT INTO `sys_district` VALUES ('134', '易县', '8');
INSERT INTO `sys_district` VALUES ('135', '曲阳县', '8');
INSERT INTO `sys_district` VALUES ('136', '蠡县', '8');
INSERT INTO `sys_district` VALUES ('137', '顺平县', '8');
INSERT INTO `sys_district` VALUES ('138', '博野县', '8');
INSERT INTO `sys_district` VALUES ('139', '雄县', '8');
INSERT INTO `sys_district` VALUES ('140', '涿州市', '8');
INSERT INTO `sys_district` VALUES ('141', '定州市', '8');
INSERT INTO `sys_district` VALUES ('142', '安国市', '8');
INSERT INTO `sys_district` VALUES ('143', '高碑店市', '8');
INSERT INTO `sys_district` VALUES ('144', '桥东区', '9');
INSERT INTO `sys_district` VALUES ('145', '桥西区', '9');
INSERT INTO `sys_district` VALUES ('146', '宣化区', '9');
INSERT INTO `sys_district` VALUES ('147', '下花园区', '9');
INSERT INTO `sys_district` VALUES ('148', '宣化县', '9');
INSERT INTO `sys_district` VALUES ('149', '张北县', '9');
INSERT INTO `sys_district` VALUES ('150', '康保县', '9');
INSERT INTO `sys_district` VALUES ('151', '沽源县', '9');
INSERT INTO `sys_district` VALUES ('152', '尚义县', '9');
INSERT INTO `sys_district` VALUES ('153', '蔚县', '9');
INSERT INTO `sys_district` VALUES ('154', '阳原县', '9');
INSERT INTO `sys_district` VALUES ('155', '怀安县', '9');
INSERT INTO `sys_district` VALUES ('156', '万全县', '9');
INSERT INTO `sys_district` VALUES ('157', '怀来县', '9');
INSERT INTO `sys_district` VALUES ('158', '涿鹿县', '9');
INSERT INTO `sys_district` VALUES ('159', '赤城县', '9');
INSERT INTO `sys_district` VALUES ('160', '崇礼县', '9');
INSERT INTO `sys_district` VALUES ('161', '双桥区', '10');
INSERT INTO `sys_district` VALUES ('162', '双滦区', '10');
INSERT INTO `sys_district` VALUES ('163', '鹰手营子矿区', '10');
INSERT INTO `sys_district` VALUES ('164', '承德县', '10');
INSERT INTO `sys_district` VALUES ('165', '兴隆县', '10');
INSERT INTO `sys_district` VALUES ('166', '平泉县', '10');
INSERT INTO `sys_district` VALUES ('167', '滦平县', '10');
INSERT INTO `sys_district` VALUES ('168', '隆化县', '10');
INSERT INTO `sys_district` VALUES ('169', '丰宁满族自治县', '10');
INSERT INTO `sys_district` VALUES ('170', '宽城满族自治县', '10');
INSERT INTO `sys_district` VALUES ('171', '围场满族蒙古族自治县', '10');
INSERT INTO `sys_district` VALUES ('172', '新华区', '11');
INSERT INTO `sys_district` VALUES ('173', '运河区', '11');
INSERT INTO `sys_district` VALUES ('174', '沧县', '11');
INSERT INTO `sys_district` VALUES ('175', '青县', '11');
INSERT INTO `sys_district` VALUES ('176', '东光县', '11');
INSERT INTO `sys_district` VALUES ('177', '海兴县', '11');
INSERT INTO `sys_district` VALUES ('178', '盐山县', '11');
INSERT INTO `sys_district` VALUES ('179', '肃宁县', '11');
INSERT INTO `sys_district` VALUES ('180', '南皮县', '11');
INSERT INTO `sys_district` VALUES ('181', '吴桥县', '11');
INSERT INTO `sys_district` VALUES ('182', '献县', '11');
INSERT INTO `sys_district` VALUES ('183', '孟村回族自治县', '11');
INSERT INTO `sys_district` VALUES ('184', '泊头市', '11');
INSERT INTO `sys_district` VALUES ('185', '任丘市', '11');
INSERT INTO `sys_district` VALUES ('186', '黄骅市', '11');
INSERT INTO `sys_district` VALUES ('187', '河间市', '11');
INSERT INTO `sys_district` VALUES ('188', '安次区', '12');
INSERT INTO `sys_district` VALUES ('189', '广阳区', '12');
INSERT INTO `sys_district` VALUES ('190', '固安县', '12');
INSERT INTO `sys_district` VALUES ('191', '永清县', '12');
INSERT INTO `sys_district` VALUES ('192', '香河县', '12');
INSERT INTO `sys_district` VALUES ('193', '大城县', '12');
INSERT INTO `sys_district` VALUES ('194', '文安县', '12');
INSERT INTO `sys_district` VALUES ('195', '大厂回族自治县', '12');
INSERT INTO `sys_district` VALUES ('196', '霸州市', '12');
INSERT INTO `sys_district` VALUES ('197', '三河市', '12');
INSERT INTO `sys_district` VALUES ('198', '桃城区', '13');
INSERT INTO `sys_district` VALUES ('199', '枣强县', '13');
INSERT INTO `sys_district` VALUES ('200', '武邑县', '13');
INSERT INTO `sys_district` VALUES ('201', '武强县', '13');
INSERT INTO `sys_district` VALUES ('202', '饶阳县', '13');
INSERT INTO `sys_district` VALUES ('203', '安平县', '13');
INSERT INTO `sys_district` VALUES ('204', '故城县', '13');
INSERT INTO `sys_district` VALUES ('205', '景县', '13');
INSERT INTO `sys_district` VALUES ('206', '阜城县', '13');
INSERT INTO `sys_district` VALUES ('207', '冀州市', '13');
INSERT INTO `sys_district` VALUES ('208', '深州市', '13');
INSERT INTO `sys_district` VALUES ('209', '小店区', '14');
INSERT INTO `sys_district` VALUES ('210', '迎泽区', '14');
INSERT INTO `sys_district` VALUES ('211', '杏花岭区', '14');
INSERT INTO `sys_district` VALUES ('212', '尖草坪区', '14');
INSERT INTO `sys_district` VALUES ('213', '万柏林区', '14');
INSERT INTO `sys_district` VALUES ('214', '晋源区', '14');
INSERT INTO `sys_district` VALUES ('215', '清徐县', '14');
INSERT INTO `sys_district` VALUES ('216', '阳曲县', '14');
INSERT INTO `sys_district` VALUES ('217', '娄烦县', '14');
INSERT INTO `sys_district` VALUES ('218', '古交市', '14');
INSERT INTO `sys_district` VALUES ('219', '城区', '15');
INSERT INTO `sys_district` VALUES ('220', '矿区', '15');
INSERT INTO `sys_district` VALUES ('221', '南郊区', '15');
INSERT INTO `sys_district` VALUES ('222', '新荣区', '15');
INSERT INTO `sys_district` VALUES ('223', '阳高县', '15');
INSERT INTO `sys_district` VALUES ('224', '天镇县', '15');
INSERT INTO `sys_district` VALUES ('225', '广灵县', '15');
INSERT INTO `sys_district` VALUES ('226', '灵丘县', '15');
INSERT INTO `sys_district` VALUES ('227', '浑源县', '15');
INSERT INTO `sys_district` VALUES ('228', '左云县', '15');
INSERT INTO `sys_district` VALUES ('229', '大同县', '15');
INSERT INTO `sys_district` VALUES ('230', '城区', '16');
INSERT INTO `sys_district` VALUES ('231', '矿区', '16');
INSERT INTO `sys_district` VALUES ('232', '郊区', '16');
INSERT INTO `sys_district` VALUES ('233', '平定县', '16');
INSERT INTO `sys_district` VALUES ('234', '盂县', '16');
INSERT INTO `sys_district` VALUES ('235', '城区', '17');
INSERT INTO `sys_district` VALUES ('236', '郊区', '17');
INSERT INTO `sys_district` VALUES ('237', '长治县', '17');
INSERT INTO `sys_district` VALUES ('238', '襄垣县', '17');
INSERT INTO `sys_district` VALUES ('239', '屯留县', '17');
INSERT INTO `sys_district` VALUES ('240', '平顺县', '17');
INSERT INTO `sys_district` VALUES ('241', '黎城县', '17');
INSERT INTO `sys_district` VALUES ('242', '壶关县', '17');
INSERT INTO `sys_district` VALUES ('243', '长子县', '17');
INSERT INTO `sys_district` VALUES ('244', '武乡县', '17');
INSERT INTO `sys_district` VALUES ('245', '沁县', '17');
INSERT INTO `sys_district` VALUES ('246', '沁源县', '17');
INSERT INTO `sys_district` VALUES ('247', '潞城市', '17');
INSERT INTO `sys_district` VALUES ('248', '城区', '18');
INSERT INTO `sys_district` VALUES ('249', '沁水县', '18');
INSERT INTO `sys_district` VALUES ('250', '阳城县', '18');
INSERT INTO `sys_district` VALUES ('251', '陵川县', '18');
INSERT INTO `sys_district` VALUES ('252', '泽州县', '18');
INSERT INTO `sys_district` VALUES ('253', '高平市', '18');
INSERT INTO `sys_district` VALUES ('254', '朔城区', '19');
INSERT INTO `sys_district` VALUES ('255', '平鲁区', '19');
INSERT INTO `sys_district` VALUES ('256', '山阴县', '19');
INSERT INTO `sys_district` VALUES ('257', '应县', '19');
INSERT INTO `sys_district` VALUES ('258', '右玉县', '19');
INSERT INTO `sys_district` VALUES ('259', '怀仁县', '19');
INSERT INTO `sys_district` VALUES ('260', '榆次区', '20');
INSERT INTO `sys_district` VALUES ('261', '榆社县', '20');
INSERT INTO `sys_district` VALUES ('262', '左权县', '20');
INSERT INTO `sys_district` VALUES ('263', '和顺县', '20');
INSERT INTO `sys_district` VALUES ('264', '昔阳县', '20');
INSERT INTO `sys_district` VALUES ('265', '寿阳县', '20');
INSERT INTO `sys_district` VALUES ('266', '太谷县', '20');
INSERT INTO `sys_district` VALUES ('267', '祁县', '20');
INSERT INTO `sys_district` VALUES ('268', '平遥县', '20');
INSERT INTO `sys_district` VALUES ('269', '灵石县', '20');
INSERT INTO `sys_district` VALUES ('270', '介休市', '20');
INSERT INTO `sys_district` VALUES ('271', '盐湖区', '21');
INSERT INTO `sys_district` VALUES ('272', '临猗县', '21');
INSERT INTO `sys_district` VALUES ('273', '万荣县', '21');
INSERT INTO `sys_district` VALUES ('274', '闻喜县', '21');
INSERT INTO `sys_district` VALUES ('275', '稷山县', '21');
INSERT INTO `sys_district` VALUES ('276', '新绛县', '21');
INSERT INTO `sys_district` VALUES ('277', '绛县', '21');
INSERT INTO `sys_district` VALUES ('278', '垣曲县', '21');
INSERT INTO `sys_district` VALUES ('279', '夏县', '21');
INSERT INTO `sys_district` VALUES ('280', '平陆县', '21');
INSERT INTO `sys_district` VALUES ('281', '芮城县', '21');
INSERT INTO `sys_district` VALUES ('282', '永济市', '21');
INSERT INTO `sys_district` VALUES ('283', '河津市', '21');
INSERT INTO `sys_district` VALUES ('284', '忻府区', '22');
INSERT INTO `sys_district` VALUES ('285', '定襄县', '22');
INSERT INTO `sys_district` VALUES ('286', '五台县', '22');
INSERT INTO `sys_district` VALUES ('287', '代县', '22');
INSERT INTO `sys_district` VALUES ('288', '繁峙县', '22');
INSERT INTO `sys_district` VALUES ('289', '宁武县', '22');
INSERT INTO `sys_district` VALUES ('290', '静乐县', '22');
INSERT INTO `sys_district` VALUES ('291', '神池县', '22');
INSERT INTO `sys_district` VALUES ('292', '五寨县', '22');
INSERT INTO `sys_district` VALUES ('293', '岢岚县', '22');
INSERT INTO `sys_district` VALUES ('294', '河曲县', '22');
INSERT INTO `sys_district` VALUES ('295', '保德县', '22');
INSERT INTO `sys_district` VALUES ('296', '偏关县', '22');
INSERT INTO `sys_district` VALUES ('297', '原平市', '22');
INSERT INTO `sys_district` VALUES ('298', '尧都区', '23');
INSERT INTO `sys_district` VALUES ('299', '曲沃县', '23');
INSERT INTO `sys_district` VALUES ('300', '翼城县', '23');
INSERT INTO `sys_district` VALUES ('301', '襄汾县', '23');
INSERT INTO `sys_district` VALUES ('302', '洪洞县', '23');
INSERT INTO `sys_district` VALUES ('303', '古县', '23');
INSERT INTO `sys_district` VALUES ('304', '安泽县', '23');
INSERT INTO `sys_district` VALUES ('305', '浮山县', '23');
INSERT INTO `sys_district` VALUES ('306', '吉县', '23');
INSERT INTO `sys_district` VALUES ('307', '乡宁县', '23');
INSERT INTO `sys_district` VALUES ('308', '大宁县', '23');
INSERT INTO `sys_district` VALUES ('309', '隰县', '23');
INSERT INTO `sys_district` VALUES ('310', '永和县', '23');
INSERT INTO `sys_district` VALUES ('311', '蒲县', '23');
INSERT INTO `sys_district` VALUES ('312', '汾西县', '23');
INSERT INTO `sys_district` VALUES ('313', '侯马市', '23');
INSERT INTO `sys_district` VALUES ('314', '霍州市', '23');
INSERT INTO `sys_district` VALUES ('315', '离石区', '24');
INSERT INTO `sys_district` VALUES ('316', '文水县', '24');
INSERT INTO `sys_district` VALUES ('317', '交城县', '24');
INSERT INTO `sys_district` VALUES ('318', '兴县', '24');
INSERT INTO `sys_district` VALUES ('319', '临县', '24');
INSERT INTO `sys_district` VALUES ('320', '柳林县', '24');
INSERT INTO `sys_district` VALUES ('321', '石楼县', '24');
INSERT INTO `sys_district` VALUES ('322', '岚县', '24');
INSERT INTO `sys_district` VALUES ('323', '方山县', '24');
INSERT INTO `sys_district` VALUES ('324', '中阳县', '24');
INSERT INTO `sys_district` VALUES ('325', '交口县', '24');
INSERT INTO `sys_district` VALUES ('326', '孝义市', '24');
INSERT INTO `sys_district` VALUES ('327', '汾阳市', '24');
INSERT INTO `sys_district` VALUES ('328', '新城区', '25');
INSERT INTO `sys_district` VALUES ('329', '回民区', '25');
INSERT INTO `sys_district` VALUES ('330', '玉泉区', '25');
INSERT INTO `sys_district` VALUES ('331', '赛罕区', '25');
INSERT INTO `sys_district` VALUES ('332', '土默特左旗', '25');
INSERT INTO `sys_district` VALUES ('333', '托克托县', '25');
INSERT INTO `sys_district` VALUES ('334', '和林格尔县', '25');
INSERT INTO `sys_district` VALUES ('335', '清水河县', '25');
INSERT INTO `sys_district` VALUES ('336', '武川县', '25');
INSERT INTO `sys_district` VALUES ('337', '东河区', '26');
INSERT INTO `sys_district` VALUES ('338', '昆都仑区', '26');
INSERT INTO `sys_district` VALUES ('339', '青山区', '26');
INSERT INTO `sys_district` VALUES ('340', '石拐区', '26');
INSERT INTO `sys_district` VALUES ('341', '白云矿区', '26');
INSERT INTO `sys_district` VALUES ('342', '九原区', '26');
INSERT INTO `sys_district` VALUES ('343', '土默特右旗', '26');
INSERT INTO `sys_district` VALUES ('344', '固阳县', '26');
INSERT INTO `sys_district` VALUES ('345', '达尔罕茂明安联合旗', '26');
INSERT INTO `sys_district` VALUES ('346', '海勃湾区', '27');
INSERT INTO `sys_district` VALUES ('347', '海南区', '27');
INSERT INTO `sys_district` VALUES ('348', '乌达区', '27');
INSERT INTO `sys_district` VALUES ('349', '红山区', '28');
INSERT INTO `sys_district` VALUES ('350', '元宝山区', '28');
INSERT INTO `sys_district` VALUES ('351', '松山区', '28');
INSERT INTO `sys_district` VALUES ('352', '阿鲁科尔沁旗', '28');
INSERT INTO `sys_district` VALUES ('353', '巴林左旗', '28');
INSERT INTO `sys_district` VALUES ('354', '巴林右旗', '28');
INSERT INTO `sys_district` VALUES ('355', '林西县', '28');
INSERT INTO `sys_district` VALUES ('356', '克什克腾旗', '28');
INSERT INTO `sys_district` VALUES ('357', '翁牛特旗', '28');
INSERT INTO `sys_district` VALUES ('358', '喀喇沁旗', '28');
INSERT INTO `sys_district` VALUES ('359', '宁城县', '28');
INSERT INTO `sys_district` VALUES ('360', '敖汉旗', '28');
INSERT INTO `sys_district` VALUES ('361', '科尔沁区', '29');
INSERT INTO `sys_district` VALUES ('362', '科尔沁左翼中旗', '29');
INSERT INTO `sys_district` VALUES ('363', '科尔沁左翼后旗', '29');
INSERT INTO `sys_district` VALUES ('364', '开鲁县', '29');
INSERT INTO `sys_district` VALUES ('365', '库伦旗', '29');
INSERT INTO `sys_district` VALUES ('366', '奈曼旗', '29');
INSERT INTO `sys_district` VALUES ('367', '扎鲁特旗', '29');
INSERT INTO `sys_district` VALUES ('368', '霍林郭勒市', '29');
INSERT INTO `sys_district` VALUES ('369', '东胜区', '30');
INSERT INTO `sys_district` VALUES ('370', '达拉特旗', '30');
INSERT INTO `sys_district` VALUES ('371', '准格尔旗', '30');
INSERT INTO `sys_district` VALUES ('372', '鄂托克前旗', '30');
INSERT INTO `sys_district` VALUES ('373', '鄂托克旗', '30');
INSERT INTO `sys_district` VALUES ('374', '杭锦旗', '30');
INSERT INTO `sys_district` VALUES ('375', '乌审旗', '30');
INSERT INTO `sys_district` VALUES ('376', '伊金霍洛旗', '30');
INSERT INTO `sys_district` VALUES ('377', '海拉尔区', '31');
INSERT INTO `sys_district` VALUES ('378', '阿荣旗', '31');
INSERT INTO `sys_district` VALUES ('379', '莫力达瓦达斡尔族自治旗', '31');
INSERT INTO `sys_district` VALUES ('380', '鄂伦春自治旗', '31');
INSERT INTO `sys_district` VALUES ('381', '鄂温克族自治旗', '31');
INSERT INTO `sys_district` VALUES ('382', '陈巴尔虎旗', '31');
INSERT INTO `sys_district` VALUES ('383', '新巴尔虎左旗', '31');
INSERT INTO `sys_district` VALUES ('384', '新巴尔虎右旗', '31');
INSERT INTO `sys_district` VALUES ('385', '满洲里市', '31');
INSERT INTO `sys_district` VALUES ('386', '牙克石市', '31');
INSERT INTO `sys_district` VALUES ('387', '扎兰屯市', '31');
INSERT INTO `sys_district` VALUES ('388', '额尔古纳市', '31');
INSERT INTO `sys_district` VALUES ('389', '根河市', '31');
INSERT INTO `sys_district` VALUES ('390', '临河区', '32');
INSERT INTO `sys_district` VALUES ('391', '五原县', '32');
INSERT INTO `sys_district` VALUES ('392', '磴口县', '32');
INSERT INTO `sys_district` VALUES ('393', '乌拉特前旗', '32');
INSERT INTO `sys_district` VALUES ('394', '乌拉特中旗', '32');
INSERT INTO `sys_district` VALUES ('395', '乌拉特后旗', '32');
INSERT INTO `sys_district` VALUES ('396', '杭锦后旗', '32');
INSERT INTO `sys_district` VALUES ('397', '集宁区', '33');
INSERT INTO `sys_district` VALUES ('398', '卓资县', '33');
INSERT INTO `sys_district` VALUES ('399', '化德县', '33');
INSERT INTO `sys_district` VALUES ('400', '商都县', '33');
INSERT INTO `sys_district` VALUES ('401', '兴和县', '33');
INSERT INTO `sys_district` VALUES ('402', '凉城县', '33');
INSERT INTO `sys_district` VALUES ('403', '察哈尔右翼前旗', '33');
INSERT INTO `sys_district` VALUES ('404', '察哈尔右翼中旗', '33');
INSERT INTO `sys_district` VALUES ('405', '察哈尔右翼后旗', '33');
INSERT INTO `sys_district` VALUES ('406', '四子王旗', '33');
INSERT INTO `sys_district` VALUES ('407', '丰镇市', '33');
INSERT INTO `sys_district` VALUES ('408', '乌兰浩特市', '34');
INSERT INTO `sys_district` VALUES ('409', '阿尔山市', '34');
INSERT INTO `sys_district` VALUES ('410', '科尔沁右翼前旗', '34');
INSERT INTO `sys_district` VALUES ('411', '科尔沁右翼中旗', '34');
INSERT INTO `sys_district` VALUES ('412', '扎赉特旗', '34');
INSERT INTO `sys_district` VALUES ('413', '突泉县', '34');
INSERT INTO `sys_district` VALUES ('414', '二连浩特市', '35');
INSERT INTO `sys_district` VALUES ('415', '锡林浩特市', '35');
INSERT INTO `sys_district` VALUES ('416', '阿巴嘎旗', '35');
INSERT INTO `sys_district` VALUES ('417', '苏尼特左旗', '35');
INSERT INTO `sys_district` VALUES ('418', '苏尼特右旗', '35');
INSERT INTO `sys_district` VALUES ('419', '东乌珠穆沁旗', '35');
INSERT INTO `sys_district` VALUES ('420', '西乌珠穆沁旗', '35');
INSERT INTO `sys_district` VALUES ('421', '太仆寺旗', '35');
INSERT INTO `sys_district` VALUES ('422', '镶黄旗', '35');
INSERT INTO `sys_district` VALUES ('423', '正镶白旗', '35');
INSERT INTO `sys_district` VALUES ('424', '正蓝旗', '35');
INSERT INTO `sys_district` VALUES ('425', '多伦县', '35');
INSERT INTO `sys_district` VALUES ('426', '阿拉善左旗', '36');
INSERT INTO `sys_district` VALUES ('427', '阿拉善右旗', '36');
INSERT INTO `sys_district` VALUES ('428', '额济纳旗', '36');
INSERT INTO `sys_district` VALUES ('429', '和平区', '37');
INSERT INTO `sys_district` VALUES ('430', '沈河区', '37');
INSERT INTO `sys_district` VALUES ('431', '大东区', '37');
INSERT INTO `sys_district` VALUES ('432', '皇姑区', '37');
INSERT INTO `sys_district` VALUES ('433', '铁西区', '37');
INSERT INTO `sys_district` VALUES ('434', '苏家屯区', '37');
INSERT INTO `sys_district` VALUES ('435', '东陵区', '37');
INSERT INTO `sys_district` VALUES ('436', '新城子区', '37');
INSERT INTO `sys_district` VALUES ('437', '于洪区', '37');
INSERT INTO `sys_district` VALUES ('438', '辽中县', '37');
INSERT INTO `sys_district` VALUES ('439', '康平县', '37');
INSERT INTO `sys_district` VALUES ('440', '法库县', '37');
INSERT INTO `sys_district` VALUES ('441', '新民市', '37');
INSERT INTO `sys_district` VALUES ('442', '中山区', '38');
INSERT INTO `sys_district` VALUES ('443', '西岗区', '38');
INSERT INTO `sys_district` VALUES ('444', '沙河口区', '38');
INSERT INTO `sys_district` VALUES ('445', '甘井子区', '38');
INSERT INTO `sys_district` VALUES ('446', '旅顺口区', '38');
INSERT INTO `sys_district` VALUES ('447', '金州区', '38');
INSERT INTO `sys_district` VALUES ('448', '长海县', '38');
INSERT INTO `sys_district` VALUES ('449', '瓦房店市', '38');
INSERT INTO `sys_district` VALUES ('450', '普兰店市', '38');
INSERT INTO `sys_district` VALUES ('451', '庄河市', '38');
INSERT INTO `sys_district` VALUES ('452', '铁东区', '39');
INSERT INTO `sys_district` VALUES ('453', '铁西区', '39');
INSERT INTO `sys_district` VALUES ('454', '立山区', '39');
INSERT INTO `sys_district` VALUES ('455', '千山区', '39');
INSERT INTO `sys_district` VALUES ('456', '台安县', '39');
INSERT INTO `sys_district` VALUES ('457', '岫岩满族自治县', '39');
INSERT INTO `sys_district` VALUES ('458', '海城市', '39');
INSERT INTO `sys_district` VALUES ('459', '新抚区', '40');
INSERT INTO `sys_district` VALUES ('460', '东洲区', '40');
INSERT INTO `sys_district` VALUES ('461', '望花区', '40');
INSERT INTO `sys_district` VALUES ('462', '顺城区', '40');
INSERT INTO `sys_district` VALUES ('463', '抚顺县', '40');
INSERT INTO `sys_district` VALUES ('464', '新宾满族自治县', '40');
INSERT INTO `sys_district` VALUES ('465', '清原满族自治县', '40');
INSERT INTO `sys_district` VALUES ('466', '平山区', '41');
INSERT INTO `sys_district` VALUES ('467', '溪湖区', '41');
INSERT INTO `sys_district` VALUES ('468', '明山区', '41');
INSERT INTO `sys_district` VALUES ('469', '南芬区', '41');
INSERT INTO `sys_district` VALUES ('470', '本溪满族自治县', '41');
INSERT INTO `sys_district` VALUES ('471', '桓仁满族自治县', '41');
INSERT INTO `sys_district` VALUES ('472', '元宝区', '42');
INSERT INTO `sys_district` VALUES ('473', '振兴区', '42');
INSERT INTO `sys_district` VALUES ('474', '振安区', '42');
INSERT INTO `sys_district` VALUES ('475', '宽甸满族自治县', '42');
INSERT INTO `sys_district` VALUES ('476', '东港市', '42');
INSERT INTO `sys_district` VALUES ('477', '凤城市', '42');
INSERT INTO `sys_district` VALUES ('478', '古塔区', '43');
INSERT INTO `sys_district` VALUES ('479', '凌河区', '43');
INSERT INTO `sys_district` VALUES ('480', '太和区', '43');
INSERT INTO `sys_district` VALUES ('481', '黑山县', '43');
INSERT INTO `sys_district` VALUES ('482', '义县', '43');
INSERT INTO `sys_district` VALUES ('483', '凌海市', '43');
INSERT INTO `sys_district` VALUES ('484', '北宁市', '43');
INSERT INTO `sys_district` VALUES ('485', '站前区', '44');
INSERT INTO `sys_district` VALUES ('486', '西市区', '44');
INSERT INTO `sys_district` VALUES ('487', '鲅鱼圈区', '44');
INSERT INTO `sys_district` VALUES ('488', '老边区', '44');
INSERT INTO `sys_district` VALUES ('489', '盖州市', '44');
INSERT INTO `sys_district` VALUES ('490', '大石桥市', '44');
INSERT INTO `sys_district` VALUES ('491', '海州区', '45');
INSERT INTO `sys_district` VALUES ('492', '新邱区', '45');
INSERT INTO `sys_district` VALUES ('493', '太平区', '45');
INSERT INTO `sys_district` VALUES ('494', '清河门区', '45');
INSERT INTO `sys_district` VALUES ('495', '细河区', '45');
INSERT INTO `sys_district` VALUES ('496', '阜新蒙古族自治县', '45');
INSERT INTO `sys_district` VALUES ('497', '彰武县', '45');
INSERT INTO `sys_district` VALUES ('498', '白塔区', '46');
INSERT INTO `sys_district` VALUES ('499', '文圣区', '46');
INSERT INTO `sys_district` VALUES ('500', '宏伟区', '46');
INSERT INTO `sys_district` VALUES ('501', '弓长岭区', '46');
INSERT INTO `sys_district` VALUES ('502', '太子河区', '46');
INSERT INTO `sys_district` VALUES ('503', '辽阳县', '46');
INSERT INTO `sys_district` VALUES ('504', '灯塔市', '46');
INSERT INTO `sys_district` VALUES ('505', '双台子区', '47');
INSERT INTO `sys_district` VALUES ('506', '兴隆台区', '47');
INSERT INTO `sys_district` VALUES ('507', '大洼县', '47');
INSERT INTO `sys_district` VALUES ('508', '盘山县', '47');
INSERT INTO `sys_district` VALUES ('509', '银州区', '48');
INSERT INTO `sys_district` VALUES ('510', '清河区', '48');
INSERT INTO `sys_district` VALUES ('511', '铁岭县', '48');
INSERT INTO `sys_district` VALUES ('512', '西丰县', '48');
INSERT INTO `sys_district` VALUES ('513', '昌图县', '48');
INSERT INTO `sys_district` VALUES ('514', '调兵山市', '48');
INSERT INTO `sys_district` VALUES ('515', '开原市', '48');
INSERT INTO `sys_district` VALUES ('516', '双塔区', '49');
INSERT INTO `sys_district` VALUES ('517', '龙城区', '49');
INSERT INTO `sys_district` VALUES ('518', '朝阳县', '49');
INSERT INTO `sys_district` VALUES ('519', '建平县', '49');
INSERT INTO `sys_district` VALUES ('520', '喀喇沁左翼蒙古族自治县', '49');
INSERT INTO `sys_district` VALUES ('521', '北票市', '49');
INSERT INTO `sys_district` VALUES ('522', '凌源市', '49');
INSERT INTO `sys_district` VALUES ('523', '连山区', '50');
INSERT INTO `sys_district` VALUES ('524', '龙港区', '50');
INSERT INTO `sys_district` VALUES ('525', '南票区', '50');
INSERT INTO `sys_district` VALUES ('526', '绥中县', '50');
INSERT INTO `sys_district` VALUES ('527', '建昌县', '50');
INSERT INTO `sys_district` VALUES ('528', '兴城市', '50');
INSERT INTO `sys_district` VALUES ('529', '南关区', '51');
INSERT INTO `sys_district` VALUES ('530', '宽城区', '51');
INSERT INTO `sys_district` VALUES ('531', '朝阳区', '51');
INSERT INTO `sys_district` VALUES ('532', '二道区', '51');
INSERT INTO `sys_district` VALUES ('533', '绿园区', '51');
INSERT INTO `sys_district` VALUES ('534', '双阳区', '51');
INSERT INTO `sys_district` VALUES ('535', '农安县', '51');
INSERT INTO `sys_district` VALUES ('536', '九台市', '51');
INSERT INTO `sys_district` VALUES ('537', '榆树市', '51');
INSERT INTO `sys_district` VALUES ('538', '德惠市', '51');
INSERT INTO `sys_district` VALUES ('539', '昌邑区', '52');
INSERT INTO `sys_district` VALUES ('540', '龙潭区', '52');
INSERT INTO `sys_district` VALUES ('541', '船营区', '52');
INSERT INTO `sys_district` VALUES ('542', '丰满区', '52');
INSERT INTO `sys_district` VALUES ('543', '永吉县', '52');
INSERT INTO `sys_district` VALUES ('544', '蛟河市', '52');
INSERT INTO `sys_district` VALUES ('545', '桦甸市', '52');
INSERT INTO `sys_district` VALUES ('546', '舒兰市', '52');
INSERT INTO `sys_district` VALUES ('547', '磐石市', '52');
INSERT INTO `sys_district` VALUES ('548', '铁西区', '53');
INSERT INTO `sys_district` VALUES ('549', '铁东区', '53');
INSERT INTO `sys_district` VALUES ('550', '梨树县', '53');
INSERT INTO `sys_district` VALUES ('551', '伊通满族自治县', '53');
INSERT INTO `sys_district` VALUES ('552', '公主岭市', '53');
INSERT INTO `sys_district` VALUES ('553', '双辽市', '53');
INSERT INTO `sys_district` VALUES ('554', '龙山区', '54');
INSERT INTO `sys_district` VALUES ('555', '西安区', '54');
INSERT INTO `sys_district` VALUES ('556', '东丰县', '54');
INSERT INTO `sys_district` VALUES ('557', '东辽县', '54');
INSERT INTO `sys_district` VALUES ('558', '东昌区', '55');
INSERT INTO `sys_district` VALUES ('559', '二道江区', '55');
INSERT INTO `sys_district` VALUES ('560', '通化县', '55');
INSERT INTO `sys_district` VALUES ('561', '辉南县', '55');
INSERT INTO `sys_district` VALUES ('562', '柳河县', '55');
INSERT INTO `sys_district` VALUES ('563', '梅河口市', '55');
INSERT INTO `sys_district` VALUES ('564', '集安市', '55');
INSERT INTO `sys_district` VALUES ('565', '八道江区', '56');
INSERT INTO `sys_district` VALUES ('566', '抚松县', '56');
INSERT INTO `sys_district` VALUES ('567', '靖宇县', '56');
INSERT INTO `sys_district` VALUES ('568', '长白朝鲜族自治县', '56');
INSERT INTO `sys_district` VALUES ('569', '江源县', '56');
INSERT INTO `sys_district` VALUES ('570', '临江市', '56');
INSERT INTO `sys_district` VALUES ('571', '宁江区', '57');
INSERT INTO `sys_district` VALUES ('572', '前郭尔罗斯蒙古族自治县', '57');
INSERT INTO `sys_district` VALUES ('573', '长岭县', '57');
INSERT INTO `sys_district` VALUES ('574', '乾安县', '57');
INSERT INTO `sys_district` VALUES ('575', '扶余县', '57');
INSERT INTO `sys_district` VALUES ('576', '洮北区', '58');
INSERT INTO `sys_district` VALUES ('577', '镇赉县', '58');
INSERT INTO `sys_district` VALUES ('578', '通榆县', '58');
INSERT INTO `sys_district` VALUES ('579', '洮南市', '58');
INSERT INTO `sys_district` VALUES ('580', '大安市', '58');
INSERT INTO `sys_district` VALUES ('581', '延吉市', '59');
INSERT INTO `sys_district` VALUES ('582', '图们市', '59');
INSERT INTO `sys_district` VALUES ('583', '敦化市', '59');
INSERT INTO `sys_district` VALUES ('584', '珲春市', '59');
INSERT INTO `sys_district` VALUES ('585', '龙井市', '59');
INSERT INTO `sys_district` VALUES ('586', '和龙市', '59');
INSERT INTO `sys_district` VALUES ('587', '汪清县', '59');
INSERT INTO `sys_district` VALUES ('588', '安图县', '59');
INSERT INTO `sys_district` VALUES ('589', '道里区', '60');
INSERT INTO `sys_district` VALUES ('590', '南岗区', '60');
INSERT INTO `sys_district` VALUES ('591', '道外区', '60');
INSERT INTO `sys_district` VALUES ('592', '香坊区', '60');
INSERT INTO `sys_district` VALUES ('593', '动力区', '60');
INSERT INTO `sys_district` VALUES ('594', '平房区', '60');
INSERT INTO `sys_district` VALUES ('595', '松北区', '60');
INSERT INTO `sys_district` VALUES ('596', '呼兰区', '60');
INSERT INTO `sys_district` VALUES ('597', '依兰县', '60');
INSERT INTO `sys_district` VALUES ('598', '方正县', '60');
INSERT INTO `sys_district` VALUES ('599', '宾县', '60');
INSERT INTO `sys_district` VALUES ('600', '巴彦县', '60');
INSERT INTO `sys_district` VALUES ('601', '木兰县', '60');
INSERT INTO `sys_district` VALUES ('602', '通河县', '60');
INSERT INTO `sys_district` VALUES ('603', '延寿县', '60');
INSERT INTO `sys_district` VALUES ('604', '阿城市', '60');
INSERT INTO `sys_district` VALUES ('605', '双城市', '60');
INSERT INTO `sys_district` VALUES ('606', '尚志市', '60');
INSERT INTO `sys_district` VALUES ('607', '五常市', '60');
INSERT INTO `sys_district` VALUES ('608', '龙沙区', '61');
INSERT INTO `sys_district` VALUES ('609', '建华区', '61');
INSERT INTO `sys_district` VALUES ('610', '铁锋区', '61');
INSERT INTO `sys_district` VALUES ('611', '昂昂溪区', '61');
INSERT INTO `sys_district` VALUES ('612', '富拉尔基区', '61');
INSERT INTO `sys_district` VALUES ('613', '碾子山区', '61');
INSERT INTO `sys_district` VALUES ('614', '梅里斯达斡尔族区', '61');
INSERT INTO `sys_district` VALUES ('615', '龙江县', '61');
INSERT INTO `sys_district` VALUES ('616', '依安县', '61');
INSERT INTO `sys_district` VALUES ('617', '泰来县', '61');
INSERT INTO `sys_district` VALUES ('618', '甘南县', '61');
INSERT INTO `sys_district` VALUES ('619', '富裕县', '61');
INSERT INTO `sys_district` VALUES ('620', '克山县', '61');
INSERT INTO `sys_district` VALUES ('621', '克东县', '61');
INSERT INTO `sys_district` VALUES ('622', '拜泉县', '61');
INSERT INTO `sys_district` VALUES ('623', '讷河市', '61');
INSERT INTO `sys_district` VALUES ('624', '鸡冠区', '62');
INSERT INTO `sys_district` VALUES ('625', '恒山区', '62');
INSERT INTO `sys_district` VALUES ('626', '滴道区', '62');
INSERT INTO `sys_district` VALUES ('627', '梨树区', '62');
INSERT INTO `sys_district` VALUES ('628', '城子河区', '62');
INSERT INTO `sys_district` VALUES ('629', '麻山区', '62');
INSERT INTO `sys_district` VALUES ('630', '鸡东县', '62');
INSERT INTO `sys_district` VALUES ('631', '虎林市', '62');
INSERT INTO `sys_district` VALUES ('632', '密山市', '62');
INSERT INTO `sys_district` VALUES ('633', '向阳区', '63');
INSERT INTO `sys_district` VALUES ('634', '工农区', '63');
INSERT INTO `sys_district` VALUES ('635', '南山区', '63');
INSERT INTO `sys_district` VALUES ('636', '兴安区', '63');
INSERT INTO `sys_district` VALUES ('637', '东山区', '63');
INSERT INTO `sys_district` VALUES ('638', '兴山区', '63');
INSERT INTO `sys_district` VALUES ('639', '萝北县', '63');
INSERT INTO `sys_district` VALUES ('640', '绥滨县', '63');
INSERT INTO `sys_district` VALUES ('641', '尖山区', '64');
INSERT INTO `sys_district` VALUES ('642', '岭东区', '64');
INSERT INTO `sys_district` VALUES ('643', '四方台区', '64');
INSERT INTO `sys_district` VALUES ('644', '宝山区', '64');
INSERT INTO `sys_district` VALUES ('645', '集贤县', '64');
INSERT INTO `sys_district` VALUES ('646', '友谊县', '64');
INSERT INTO `sys_district` VALUES ('647', '宝清县', '64');
INSERT INTO `sys_district` VALUES ('648', '饶河县', '64');
INSERT INTO `sys_district` VALUES ('649', '萨尔图区', '65');
INSERT INTO `sys_district` VALUES ('650', '龙凤区', '65');
INSERT INTO `sys_district` VALUES ('651', '让胡路区', '65');
INSERT INTO `sys_district` VALUES ('652', '红岗区', '65');
INSERT INTO `sys_district` VALUES ('653', '大同区', '65');
INSERT INTO `sys_district` VALUES ('654', '肇州县', '65');
INSERT INTO `sys_district` VALUES ('655', '肇源县', '65');
INSERT INTO `sys_district` VALUES ('656', '林甸县', '65');
INSERT INTO `sys_district` VALUES ('657', '杜尔伯特蒙古族自治县', '65');
INSERT INTO `sys_district` VALUES ('658', '伊春区', '66');
INSERT INTO `sys_district` VALUES ('659', '南岔区', '66');
INSERT INTO `sys_district` VALUES ('660', '友好区', '66');
INSERT INTO `sys_district` VALUES ('661', '西林区', '66');
INSERT INTO `sys_district` VALUES ('662', '翠峦区', '66');
INSERT INTO `sys_district` VALUES ('663', '新青区', '66');
INSERT INTO `sys_district` VALUES ('664', '美溪区', '66');
INSERT INTO `sys_district` VALUES ('665', '金山屯区', '66');
INSERT INTO `sys_district` VALUES ('666', '五营区', '66');
INSERT INTO `sys_district` VALUES ('667', '乌马河区', '66');
INSERT INTO `sys_district` VALUES ('668', '汤旺河区', '66');
INSERT INTO `sys_district` VALUES ('669', '带岭区', '66');
INSERT INTO `sys_district` VALUES ('670', '乌伊岭区', '66');
INSERT INTO `sys_district` VALUES ('671', '红星区', '66');
INSERT INTO `sys_district` VALUES ('672', '上甘岭区', '66');
INSERT INTO `sys_district` VALUES ('673', '嘉荫县', '66');
INSERT INTO `sys_district` VALUES ('674', '铁力市', '66');
INSERT INTO `sys_district` VALUES ('675', '永红区', '67');
INSERT INTO `sys_district` VALUES ('676', '向阳区', '67');
INSERT INTO `sys_district` VALUES ('677', '前进区', '67');
INSERT INTO `sys_district` VALUES ('678', '东风区', '67');
INSERT INTO `sys_district` VALUES ('679', '郊区', '67');
INSERT INTO `sys_district` VALUES ('680', '桦南县', '67');
INSERT INTO `sys_district` VALUES ('681', '桦川县', '67');
INSERT INTO `sys_district` VALUES ('682', '汤原县', '67');
INSERT INTO `sys_district` VALUES ('683', '抚远县', '67');
INSERT INTO `sys_district` VALUES ('684', '同江市', '67');
INSERT INTO `sys_district` VALUES ('685', '富锦市', '67');
INSERT INTO `sys_district` VALUES ('686', '新兴区', '68');
INSERT INTO `sys_district` VALUES ('687', '桃山区', '68');
INSERT INTO `sys_district` VALUES ('688', '茄子河区', '68');
INSERT INTO `sys_district` VALUES ('689', '勃利县', '68');
INSERT INTO `sys_district` VALUES ('690', '东安区', '69');
INSERT INTO `sys_district` VALUES ('691', '阳明区', '69');
INSERT INTO `sys_district` VALUES ('692', '爱民区', '69');
INSERT INTO `sys_district` VALUES ('693', '西安区', '69');
INSERT INTO `sys_district` VALUES ('694', '东宁县', '69');
INSERT INTO `sys_district` VALUES ('695', '林口县', '69');
INSERT INTO `sys_district` VALUES ('696', '绥芬河市', '69');
INSERT INTO `sys_district` VALUES ('697', '海林市', '69');
INSERT INTO `sys_district` VALUES ('698', '宁安市', '69');
INSERT INTO `sys_district` VALUES ('699', '穆棱市', '69');
INSERT INTO `sys_district` VALUES ('700', '爱辉区', '70');
INSERT INTO `sys_district` VALUES ('701', '嫩江县', '70');
INSERT INTO `sys_district` VALUES ('702', '逊克县', '70');
INSERT INTO `sys_district` VALUES ('703', '孙吴县', '70');
INSERT INTO `sys_district` VALUES ('704', '北安市', '70');
INSERT INTO `sys_district` VALUES ('705', '五大连池市', '70');
INSERT INTO `sys_district` VALUES ('706', '北林区', '71');
INSERT INTO `sys_district` VALUES ('707', '望奎县', '71');
INSERT INTO `sys_district` VALUES ('708', '兰西县', '71');
INSERT INTO `sys_district` VALUES ('709', '青冈县', '71');
INSERT INTO `sys_district` VALUES ('710', '庆安县', '71');
INSERT INTO `sys_district` VALUES ('711', '明水县', '71');
INSERT INTO `sys_district` VALUES ('712', '绥棱县', '71');
INSERT INTO `sys_district` VALUES ('713', '安达市', '71');
INSERT INTO `sys_district` VALUES ('714', '肇东市', '71');
INSERT INTO `sys_district` VALUES ('715', '海伦市', '71');
INSERT INTO `sys_district` VALUES ('716', '呼玛县', '72');
INSERT INTO `sys_district` VALUES ('717', '塔河县', '72');
INSERT INTO `sys_district` VALUES ('718', '漠河县', '72');
INSERT INTO `sys_district` VALUES ('719', '黄浦区', '73');
INSERT INTO `sys_district` VALUES ('720', '卢湾区', '73');
INSERT INTO `sys_district` VALUES ('721', '徐汇区', '73');
INSERT INTO `sys_district` VALUES ('722', '长宁区', '73');
INSERT INTO `sys_district` VALUES ('723', '静安区', '73');
INSERT INTO `sys_district` VALUES ('724', '普陀区', '73');
INSERT INTO `sys_district` VALUES ('725', '闸北区', '73');
INSERT INTO `sys_district` VALUES ('726', '虹口区', '73');
INSERT INTO `sys_district` VALUES ('727', '杨浦区', '73');
INSERT INTO `sys_district` VALUES ('728', '闵行区', '73');
INSERT INTO `sys_district` VALUES ('729', '宝山区', '73');
INSERT INTO `sys_district` VALUES ('730', '嘉定区', '73');
INSERT INTO `sys_district` VALUES ('731', '浦东新区', '73');
INSERT INTO `sys_district` VALUES ('732', '金山区', '73');
INSERT INTO `sys_district` VALUES ('733', '松江区', '73');
INSERT INTO `sys_district` VALUES ('734', '青浦区', '73');
INSERT INTO `sys_district` VALUES ('735', '南汇区', '73');
INSERT INTO `sys_district` VALUES ('736', '奉贤区', '73');
INSERT INTO `sys_district` VALUES ('737', '崇明县', '73');
INSERT INTO `sys_district` VALUES ('738', '玄武区', '74');
INSERT INTO `sys_district` VALUES ('739', '白下区', '74');
INSERT INTO `sys_district` VALUES ('740', '秦淮区', '74');
INSERT INTO `sys_district` VALUES ('741', '建邺区', '74');
INSERT INTO `sys_district` VALUES ('742', '鼓楼区', '74');
INSERT INTO `sys_district` VALUES ('743', '下关区', '74');
INSERT INTO `sys_district` VALUES ('744', '浦口区', '74');
INSERT INTO `sys_district` VALUES ('745', '栖霞区', '74');
INSERT INTO `sys_district` VALUES ('746', '雨花台区', '74');
INSERT INTO `sys_district` VALUES ('747', '江宁区', '74');
INSERT INTO `sys_district` VALUES ('748', '六合区', '74');
INSERT INTO `sys_district` VALUES ('749', '溧水县', '74');
INSERT INTO `sys_district` VALUES ('750', '高淳县', '74');
INSERT INTO `sys_district` VALUES ('751', '崇安区', '75');
INSERT INTO `sys_district` VALUES ('752', '南长区', '75');
INSERT INTO `sys_district` VALUES ('753', '北塘区', '75');
INSERT INTO `sys_district` VALUES ('754', '锡山区', '75');
INSERT INTO `sys_district` VALUES ('755', '惠山区', '75');
INSERT INTO `sys_district` VALUES ('756', '滨湖区', '75');
INSERT INTO `sys_district` VALUES ('757', '江阴市', '75');
INSERT INTO `sys_district` VALUES ('758', '宜兴市', '75');
INSERT INTO `sys_district` VALUES ('759', '鼓楼区', '76');
INSERT INTO `sys_district` VALUES ('760', '云龙区', '76');
INSERT INTO `sys_district` VALUES ('761', '九里区', '76');
INSERT INTO `sys_district` VALUES ('762', '贾汪区', '76');
INSERT INTO `sys_district` VALUES ('763', '泉山区', '76');
INSERT INTO `sys_district` VALUES ('764', '丰县', '76');
INSERT INTO `sys_district` VALUES ('765', '沛县', '76');
INSERT INTO `sys_district` VALUES ('766', '铜山县', '76');
INSERT INTO `sys_district` VALUES ('767', '睢宁县', '76');
INSERT INTO `sys_district` VALUES ('768', '新沂市', '76');
INSERT INTO `sys_district` VALUES ('769', '邳州市', '76');
INSERT INTO `sys_district` VALUES ('770', '天宁区', '77');
INSERT INTO `sys_district` VALUES ('771', '钟楼区', '77');
INSERT INTO `sys_district` VALUES ('772', '戚墅堰区', '77');
INSERT INTO `sys_district` VALUES ('773', '新北区', '77');
INSERT INTO `sys_district` VALUES ('774', '武进区', '77');
INSERT INTO `sys_district` VALUES ('775', '溧阳市', '77');
INSERT INTO `sys_district` VALUES ('776', '金坛市', '77');
INSERT INTO `sys_district` VALUES ('777', '沧浪区', '78');
INSERT INTO `sys_district` VALUES ('778', '平江区', '78');
INSERT INTO `sys_district` VALUES ('779', '金阊区', '78');
INSERT INTO `sys_district` VALUES ('780', '虎丘区', '78');
INSERT INTO `sys_district` VALUES ('781', '吴中区', '78');
INSERT INTO `sys_district` VALUES ('782', '相城区', '78');
INSERT INTO `sys_district` VALUES ('783', '常熟市', '78');
INSERT INTO `sys_district` VALUES ('784', '张家港市', '78');
INSERT INTO `sys_district` VALUES ('785', '昆山市', '78');
INSERT INTO `sys_district` VALUES ('786', '吴江市', '78');
INSERT INTO `sys_district` VALUES ('787', '太仓市', '78');
INSERT INTO `sys_district` VALUES ('788', '崇川区', '79');
INSERT INTO `sys_district` VALUES ('789', '港闸区', '79');
INSERT INTO `sys_district` VALUES ('790', '海安县', '79');
INSERT INTO `sys_district` VALUES ('791', '如东县', '79');
INSERT INTO `sys_district` VALUES ('792', '启东市', '79');
INSERT INTO `sys_district` VALUES ('793', '如皋市', '79');
INSERT INTO `sys_district` VALUES ('794', '通州市', '79');
INSERT INTO `sys_district` VALUES ('795', '海门市', '79');
INSERT INTO `sys_district` VALUES ('796', '连云区', '80');
INSERT INTO `sys_district` VALUES ('797', '新浦区', '80');
INSERT INTO `sys_district` VALUES ('798', '海州区', '80');
INSERT INTO `sys_district` VALUES ('799', '赣榆县', '80');
INSERT INTO `sys_district` VALUES ('800', '东海县', '80');
INSERT INTO `sys_district` VALUES ('801', '灌云县', '80');
INSERT INTO `sys_district` VALUES ('802', '灌南县', '80');
INSERT INTO `sys_district` VALUES ('803', '清河区', '81');
INSERT INTO `sys_district` VALUES ('804', '楚州区', '81');
INSERT INTO `sys_district` VALUES ('805', '淮阴区', '81');
INSERT INTO `sys_district` VALUES ('806', '清浦区', '81');
INSERT INTO `sys_district` VALUES ('807', '涟水县', '81');
INSERT INTO `sys_district` VALUES ('808', '洪泽县', '81');
INSERT INTO `sys_district` VALUES ('809', '盱眙县', '81');
INSERT INTO `sys_district` VALUES ('810', '金湖县', '81');
INSERT INTO `sys_district` VALUES ('811', '亭湖区', '82');
INSERT INTO `sys_district` VALUES ('812', '盐都区', '82');
INSERT INTO `sys_district` VALUES ('813', '响水县', '82');
INSERT INTO `sys_district` VALUES ('814', '滨海县', '82');
INSERT INTO `sys_district` VALUES ('815', '阜宁县', '82');
INSERT INTO `sys_district` VALUES ('816', '射阳县', '82');
INSERT INTO `sys_district` VALUES ('817', '建湖县', '82');
INSERT INTO `sys_district` VALUES ('818', '东台市', '82');
INSERT INTO `sys_district` VALUES ('819', '大丰市', '82');
INSERT INTO `sys_district` VALUES ('820', '广陵区', '83');
INSERT INTO `sys_district` VALUES ('821', '邗江区', '83');
INSERT INTO `sys_district` VALUES ('822', '维扬区', '83');
INSERT INTO `sys_district` VALUES ('823', '宝应县', '83');
INSERT INTO `sys_district` VALUES ('824', '仪征市', '83');
INSERT INTO `sys_district` VALUES ('825', '高邮市', '83');
INSERT INTO `sys_district` VALUES ('826', '江都市', '83');
INSERT INTO `sys_district` VALUES ('827', '京口区', '84');
INSERT INTO `sys_district` VALUES ('828', '润州区', '84');
INSERT INTO `sys_district` VALUES ('829', '丹徒区', '84');
INSERT INTO `sys_district` VALUES ('830', '丹阳市', '84');
INSERT INTO `sys_district` VALUES ('831', '扬中市', '84');
INSERT INTO `sys_district` VALUES ('832', '句容市', '84');
INSERT INTO `sys_district` VALUES ('833', '海陵区', '85');
INSERT INTO `sys_district` VALUES ('834', '高港区', '85');
INSERT INTO `sys_district` VALUES ('835', '兴化市', '85');
INSERT INTO `sys_district` VALUES ('836', '靖江市', '85');
INSERT INTO `sys_district` VALUES ('837', '泰兴市', '85');
INSERT INTO `sys_district` VALUES ('838', '姜堰市', '85');
INSERT INTO `sys_district` VALUES ('839', '宿城区', '86');
INSERT INTO `sys_district` VALUES ('840', '宿豫区', '86');
INSERT INTO `sys_district` VALUES ('841', '沭阳县', '86');
INSERT INTO `sys_district` VALUES ('842', '泗阳县', '86');
INSERT INTO `sys_district` VALUES ('843', '泗洪县', '86');
INSERT INTO `sys_district` VALUES ('844', '上城区', '87');
INSERT INTO `sys_district` VALUES ('845', '下城区', '87');
INSERT INTO `sys_district` VALUES ('846', '江干区', '87');
INSERT INTO `sys_district` VALUES ('847', '拱墅区', '87');
INSERT INTO `sys_district` VALUES ('848', '西湖区', '87');
INSERT INTO `sys_district` VALUES ('849', '滨江区', '87');
INSERT INTO `sys_district` VALUES ('850', '萧山区', '87');
INSERT INTO `sys_district` VALUES ('851', '余杭区', '87');
INSERT INTO `sys_district` VALUES ('852', '桐庐县', '87');
INSERT INTO `sys_district` VALUES ('853', '淳安县', '87');
INSERT INTO `sys_district` VALUES ('854', '建德市', '87');
INSERT INTO `sys_district` VALUES ('855', '富阳市', '87');
INSERT INTO `sys_district` VALUES ('856', '临安市', '87');
INSERT INTO `sys_district` VALUES ('857', '海曙区', '88');
INSERT INTO `sys_district` VALUES ('858', '江东区', '88');
INSERT INTO `sys_district` VALUES ('859', '江北区', '88');
INSERT INTO `sys_district` VALUES ('860', '北仑区', '88');
INSERT INTO `sys_district` VALUES ('861', '镇海区', '88');
INSERT INTO `sys_district` VALUES ('862', '鄞州区', '88');
INSERT INTO `sys_district` VALUES ('863', '象山县', '88');
INSERT INTO `sys_district` VALUES ('864', '宁海县', '88');
INSERT INTO `sys_district` VALUES ('865', '余姚市', '88');
INSERT INTO `sys_district` VALUES ('866', '慈溪市', '88');
INSERT INTO `sys_district` VALUES ('867', '奉化市', '88');
INSERT INTO `sys_district` VALUES ('868', '鹿城区', '89');
INSERT INTO `sys_district` VALUES ('869', '龙湾区', '89');
INSERT INTO `sys_district` VALUES ('870', '瓯海区', '89');
INSERT INTO `sys_district` VALUES ('871', '洞头县', '89');
INSERT INTO `sys_district` VALUES ('872', '永嘉县', '89');
INSERT INTO `sys_district` VALUES ('873', '平阳县', '89');
INSERT INTO `sys_district` VALUES ('874', '苍南县', '89');
INSERT INTO `sys_district` VALUES ('875', '文成县', '89');
INSERT INTO `sys_district` VALUES ('876', '泰顺县', '89');
INSERT INTO `sys_district` VALUES ('877', '瑞安市', '89');
INSERT INTO `sys_district` VALUES ('878', '乐清市', '89');
INSERT INTO `sys_district` VALUES ('879', '秀城区', '90');
INSERT INTO `sys_district` VALUES ('880', '秀洲区', '90');
INSERT INTO `sys_district` VALUES ('881', '嘉善县', '90');
INSERT INTO `sys_district` VALUES ('882', '海盐县', '90');
INSERT INTO `sys_district` VALUES ('883', '海宁市', '90');
INSERT INTO `sys_district` VALUES ('884', '平湖市', '90');
INSERT INTO `sys_district` VALUES ('885', '桐乡市', '90');
INSERT INTO `sys_district` VALUES ('886', '吴兴区', '91');
INSERT INTO `sys_district` VALUES ('887', '南浔区', '91');
INSERT INTO `sys_district` VALUES ('888', '德清县', '91');
INSERT INTO `sys_district` VALUES ('889', '长兴县', '91');
INSERT INTO `sys_district` VALUES ('890', '安吉县', '91');
INSERT INTO `sys_district` VALUES ('891', '越城区', '92');
INSERT INTO `sys_district` VALUES ('892', '绍兴县', '92');
INSERT INTO `sys_district` VALUES ('893', '新昌县', '92');
INSERT INTO `sys_district` VALUES ('894', '诸暨市', '92');
INSERT INTO `sys_district` VALUES ('895', '上虞市', '92');
INSERT INTO `sys_district` VALUES ('896', '嵊州市', '92');
INSERT INTO `sys_district` VALUES ('897', '婺城区', '93');
INSERT INTO `sys_district` VALUES ('898', '金东区', '93');
INSERT INTO `sys_district` VALUES ('899', '武义县', '93');
INSERT INTO `sys_district` VALUES ('900', '浦江县', '93');
INSERT INTO `sys_district` VALUES ('901', '磐安县', '93');
INSERT INTO `sys_district` VALUES ('902', '兰溪市', '93');
INSERT INTO `sys_district` VALUES ('903', '义乌市', '93');
INSERT INTO `sys_district` VALUES ('904', '东阳市', '93');
INSERT INTO `sys_district` VALUES ('905', '永康市', '93');
INSERT INTO `sys_district` VALUES ('906', '柯城区', '94');
INSERT INTO `sys_district` VALUES ('907', '衢江区', '94');
INSERT INTO `sys_district` VALUES ('908', '常山县', '94');
INSERT INTO `sys_district` VALUES ('909', '开化县', '94');
INSERT INTO `sys_district` VALUES ('910', '龙游县', '94');
INSERT INTO `sys_district` VALUES ('911', '江山市', '94');
INSERT INTO `sys_district` VALUES ('912', '定海区', '95');
INSERT INTO `sys_district` VALUES ('913', '普陀区', '95');
INSERT INTO `sys_district` VALUES ('914', '岱山县', '95');
INSERT INTO `sys_district` VALUES ('915', '嵊泗县', '95');
INSERT INTO `sys_district` VALUES ('916', '椒江区', '96');
INSERT INTO `sys_district` VALUES ('917', '黄岩区', '96');
INSERT INTO `sys_district` VALUES ('918', '路桥区', '96');
INSERT INTO `sys_district` VALUES ('919', '玉环县', '96');
INSERT INTO `sys_district` VALUES ('920', '三门县', '96');
INSERT INTO `sys_district` VALUES ('921', '天台县', '96');
INSERT INTO `sys_district` VALUES ('922', '仙居县', '96');
INSERT INTO `sys_district` VALUES ('923', '温岭市', '96');
INSERT INTO `sys_district` VALUES ('924', '临海市', '96');
INSERT INTO `sys_district` VALUES ('925', '莲都区', '97');
INSERT INTO `sys_district` VALUES ('926', '青田县', '97');
INSERT INTO `sys_district` VALUES ('927', '缙云县', '97');
INSERT INTO `sys_district` VALUES ('928', '遂昌县', '97');
INSERT INTO `sys_district` VALUES ('929', '松阳县', '97');
INSERT INTO `sys_district` VALUES ('930', '云和县', '97');
INSERT INTO `sys_district` VALUES ('931', '庆元县', '97');
INSERT INTO `sys_district` VALUES ('932', '景宁畲族自治县', '97');
INSERT INTO `sys_district` VALUES ('933', '龙泉市', '97');
INSERT INTO `sys_district` VALUES ('934', '瑶海区', '98');
INSERT INTO `sys_district` VALUES ('935', '庐阳区', '98');
INSERT INTO `sys_district` VALUES ('936', '蜀山区', '98');
INSERT INTO `sys_district` VALUES ('937', '包河区', '98');
INSERT INTO `sys_district` VALUES ('938', '长丰县', '98');
INSERT INTO `sys_district` VALUES ('939', '肥东县', '98');
INSERT INTO `sys_district` VALUES ('940', '肥西县', '98');
INSERT INTO `sys_district` VALUES ('941', '镜湖区', '99');
INSERT INTO `sys_district` VALUES ('942', '马塘区', '99');
INSERT INTO `sys_district` VALUES ('943', '新芜区', '99');
INSERT INTO `sys_district` VALUES ('944', '鸠江区', '99');
INSERT INTO `sys_district` VALUES ('945', '芜湖县', '99');
INSERT INTO `sys_district` VALUES ('946', '繁昌县', '99');
INSERT INTO `sys_district` VALUES ('947', '南陵县', '99');
INSERT INTO `sys_district` VALUES ('948', '龙子湖区', '100');
INSERT INTO `sys_district` VALUES ('949', '蚌山区', '100');
INSERT INTO `sys_district` VALUES ('950', '禹会区', '100');
INSERT INTO `sys_district` VALUES ('951', '淮上区', '100');
INSERT INTO `sys_district` VALUES ('952', '怀远县', '100');
INSERT INTO `sys_district` VALUES ('953', '五河县', '100');
INSERT INTO `sys_district` VALUES ('954', '固镇县', '100');
INSERT INTO `sys_district` VALUES ('955', '大通区', '101');
INSERT INTO `sys_district` VALUES ('956', '田家庵区', '101');
INSERT INTO `sys_district` VALUES ('957', '谢家集区', '101');
INSERT INTO `sys_district` VALUES ('958', '八公山区', '101');
INSERT INTO `sys_district` VALUES ('959', '潘集区', '101');
INSERT INTO `sys_district` VALUES ('960', '凤台县', '101');
INSERT INTO `sys_district` VALUES ('961', '金家庄区', '102');
INSERT INTO `sys_district` VALUES ('962', '花山区', '102');
INSERT INTO `sys_district` VALUES ('963', '雨山区', '102');
INSERT INTO `sys_district` VALUES ('964', '当涂县', '102');
INSERT INTO `sys_district` VALUES ('965', '杜集区', '103');
INSERT INTO `sys_district` VALUES ('966', '相山区', '103');
INSERT INTO `sys_district` VALUES ('967', '烈山区', '103');
INSERT INTO `sys_district` VALUES ('968', '濉溪县', '103');
INSERT INTO `sys_district` VALUES ('969', '铜官山区', '104');
INSERT INTO `sys_district` VALUES ('970', '狮子山区', '104');
INSERT INTO `sys_district` VALUES ('971', '郊区', '104');
INSERT INTO `sys_district` VALUES ('972', '铜陵县', '104');
INSERT INTO `sys_district` VALUES ('973', '迎江区', '105');
INSERT INTO `sys_district` VALUES ('974', '大观区', '105');
INSERT INTO `sys_district` VALUES ('975', '郊区', '105');
INSERT INTO `sys_district` VALUES ('976', '怀宁县', '105');
INSERT INTO `sys_district` VALUES ('977', '枞阳县', '105');
INSERT INTO `sys_district` VALUES ('978', '潜山县', '105');
INSERT INTO `sys_district` VALUES ('979', '太湖县', '105');
INSERT INTO `sys_district` VALUES ('980', '宿松县', '105');
INSERT INTO `sys_district` VALUES ('981', '望江县', '105');
INSERT INTO `sys_district` VALUES ('982', '岳西县', '105');
INSERT INTO `sys_district` VALUES ('983', '桐城市', '105');
INSERT INTO `sys_district` VALUES ('984', '屯溪区', '106');
INSERT INTO `sys_district` VALUES ('985', '黄山区', '106');
INSERT INTO `sys_district` VALUES ('986', '徽州区', '106');
INSERT INTO `sys_district` VALUES ('987', '歙县', '106');
INSERT INTO `sys_district` VALUES ('988', '休宁县', '106');
INSERT INTO `sys_district` VALUES ('989', '黟县', '106');
INSERT INTO `sys_district` VALUES ('990', '祁门县', '106');
INSERT INTO `sys_district` VALUES ('991', '琅琊区', '107');
INSERT INTO `sys_district` VALUES ('992', '南谯区', '107');
INSERT INTO `sys_district` VALUES ('993', '来安县', '107');
INSERT INTO `sys_district` VALUES ('994', '全椒县', '107');
INSERT INTO `sys_district` VALUES ('995', '定远县', '107');
INSERT INTO `sys_district` VALUES ('996', '凤阳县', '107');
INSERT INTO `sys_district` VALUES ('997', '天长市', '107');
INSERT INTO `sys_district` VALUES ('998', '明光市', '107');
INSERT INTO `sys_district` VALUES ('999', '颍州区', '108');
INSERT INTO `sys_district` VALUES ('1000', '颍东区', '108');
INSERT INTO `sys_district` VALUES ('1001', '颍泉区', '108');
INSERT INTO `sys_district` VALUES ('1002', '临泉县', '108');
INSERT INTO `sys_district` VALUES ('1003', '太和县', '108');
INSERT INTO `sys_district` VALUES ('1004', '阜南县', '108');
INSERT INTO `sys_district` VALUES ('1005', '颍上县', '108');
INSERT INTO `sys_district` VALUES ('1006', '界首市', '108');
INSERT INTO `sys_district` VALUES ('1007', '埇桥区', '109');
INSERT INTO `sys_district` VALUES ('1008', '砀山县', '109');
INSERT INTO `sys_district` VALUES ('1009', '萧县', '109');
INSERT INTO `sys_district` VALUES ('1010', '灵璧县', '109');
INSERT INTO `sys_district` VALUES ('1011', '泗县', '109');
INSERT INTO `sys_district` VALUES ('1012', '居巢区', '110');
INSERT INTO `sys_district` VALUES ('1013', '庐江县', '110');
INSERT INTO `sys_district` VALUES ('1014', '无为县', '110');
INSERT INTO `sys_district` VALUES ('1015', '含山县', '110');
INSERT INTO `sys_district` VALUES ('1016', '和县', '110');
INSERT INTO `sys_district` VALUES ('1017', '金安区', '111');
INSERT INTO `sys_district` VALUES ('1018', '裕安区', '111');
INSERT INTO `sys_district` VALUES ('1019', '寿县', '111');
INSERT INTO `sys_district` VALUES ('1020', '霍邱县', '111');
INSERT INTO `sys_district` VALUES ('1021', '舒城县', '111');
INSERT INTO `sys_district` VALUES ('1022', '金寨县', '111');
INSERT INTO `sys_district` VALUES ('1023', '霍山县', '111');
INSERT INTO `sys_district` VALUES ('1024', '谯城区', '112');
INSERT INTO `sys_district` VALUES ('1025', '涡阳县', '112');
INSERT INTO `sys_district` VALUES ('1026', '蒙城县', '112');
INSERT INTO `sys_district` VALUES ('1027', '利辛县', '112');
INSERT INTO `sys_district` VALUES ('1028', '贵池区', '113');
INSERT INTO `sys_district` VALUES ('1029', '东至县', '113');
INSERT INTO `sys_district` VALUES ('1030', '石台县', '113');
INSERT INTO `sys_district` VALUES ('1031', '青阳县', '113');
INSERT INTO `sys_district` VALUES ('1032', '宣州区', '114');
INSERT INTO `sys_district` VALUES ('1033', '郎溪县', '114');
INSERT INTO `sys_district` VALUES ('1034', '广德县', '114');
INSERT INTO `sys_district` VALUES ('1035', '泾县', '114');
INSERT INTO `sys_district` VALUES ('1036', '绩溪县', '114');
INSERT INTO `sys_district` VALUES ('1037', '旌德县', '114');
INSERT INTO `sys_district` VALUES ('1038', '宁国市', '114');
INSERT INTO `sys_district` VALUES ('1039', '鼓楼区', '115');
INSERT INTO `sys_district` VALUES ('1040', '台江区', '115');
INSERT INTO `sys_district` VALUES ('1041', '仓山区', '115');
INSERT INTO `sys_district` VALUES ('1042', '马尾区', '115');
INSERT INTO `sys_district` VALUES ('1043', '晋安区', '115');
INSERT INTO `sys_district` VALUES ('1044', '闽侯县', '115');
INSERT INTO `sys_district` VALUES ('1045', '连江县', '115');
INSERT INTO `sys_district` VALUES ('1046', '罗源县', '115');
INSERT INTO `sys_district` VALUES ('1047', '闽清县', '115');
INSERT INTO `sys_district` VALUES ('1048', '永泰县', '115');
INSERT INTO `sys_district` VALUES ('1049', '平潭县', '115');
INSERT INTO `sys_district` VALUES ('1050', '福清市', '115');
INSERT INTO `sys_district` VALUES ('1051', '长乐市', '115');
INSERT INTO `sys_district` VALUES ('1052', '思明区', '116');
INSERT INTO `sys_district` VALUES ('1053', '海沧区', '116');
INSERT INTO `sys_district` VALUES ('1054', '湖里区', '116');
INSERT INTO `sys_district` VALUES ('1055', '集美区', '116');
INSERT INTO `sys_district` VALUES ('1056', '同安区', '116');
INSERT INTO `sys_district` VALUES ('1057', '翔安区', '116');
INSERT INTO `sys_district` VALUES ('1058', '城厢区', '117');
INSERT INTO `sys_district` VALUES ('1059', '涵江区', '117');
INSERT INTO `sys_district` VALUES ('1060', '荔城区', '117');
INSERT INTO `sys_district` VALUES ('1061', '秀屿区', '117');
INSERT INTO `sys_district` VALUES ('1062', '仙游县', '117');
INSERT INTO `sys_district` VALUES ('1063', '梅列区', '118');
INSERT INTO `sys_district` VALUES ('1064', '三元区', '118');
INSERT INTO `sys_district` VALUES ('1065', '明溪县', '118');
INSERT INTO `sys_district` VALUES ('1066', '清流县', '118');
INSERT INTO `sys_district` VALUES ('1067', '宁化县', '118');
INSERT INTO `sys_district` VALUES ('1068', '大田县', '118');
INSERT INTO `sys_district` VALUES ('1069', '尤溪县', '118');
INSERT INTO `sys_district` VALUES ('1070', '沙县', '118');
INSERT INTO `sys_district` VALUES ('1071', '将乐县', '118');
INSERT INTO `sys_district` VALUES ('1072', '泰宁县', '118');
INSERT INTO `sys_district` VALUES ('1073', '建宁县', '118');
INSERT INTO `sys_district` VALUES ('1074', '永安市', '118');
INSERT INTO `sys_district` VALUES ('1075', '鲤城区', '119');
INSERT INTO `sys_district` VALUES ('1076', '丰泽区', '119');
INSERT INTO `sys_district` VALUES ('1077', '洛江区', '119');
INSERT INTO `sys_district` VALUES ('1078', '泉港区', '119');
INSERT INTO `sys_district` VALUES ('1079', '惠安县', '119');
INSERT INTO `sys_district` VALUES ('1080', '安溪县', '119');
INSERT INTO `sys_district` VALUES ('1081', '永春县', '119');
INSERT INTO `sys_district` VALUES ('1082', '德化县', '119');
INSERT INTO `sys_district` VALUES ('1083', '金门县', '119');
INSERT INTO `sys_district` VALUES ('1084', '石狮市', '119');
INSERT INTO `sys_district` VALUES ('1085', '晋江市', '119');
INSERT INTO `sys_district` VALUES ('1086', '南安市', '119');
INSERT INTO `sys_district` VALUES ('1087', '芗城区', '120');
INSERT INTO `sys_district` VALUES ('1088', '龙文区', '120');
INSERT INTO `sys_district` VALUES ('1089', '云霄县', '120');
INSERT INTO `sys_district` VALUES ('1090', '漳浦县', '120');
INSERT INTO `sys_district` VALUES ('1091', '诏安县', '120');
INSERT INTO `sys_district` VALUES ('1092', '长泰县', '120');
INSERT INTO `sys_district` VALUES ('1093', '东山县', '120');
INSERT INTO `sys_district` VALUES ('1094', '南靖县', '120');
INSERT INTO `sys_district` VALUES ('1095', '平和县', '120');
INSERT INTO `sys_district` VALUES ('1096', '华安县', '120');
INSERT INTO `sys_district` VALUES ('1097', '龙海市', '120');
INSERT INTO `sys_district` VALUES ('1098', '延平区', '121');
INSERT INTO `sys_district` VALUES ('1099', '顺昌县', '121');
INSERT INTO `sys_district` VALUES ('1100', '浦城县', '121');
INSERT INTO `sys_district` VALUES ('1101', '光泽县', '121');
INSERT INTO `sys_district` VALUES ('1102', '松溪县', '121');
INSERT INTO `sys_district` VALUES ('1103', '政和县', '121');
INSERT INTO `sys_district` VALUES ('1104', '邵武市', '121');
INSERT INTO `sys_district` VALUES ('1105', '武夷山市', '121');
INSERT INTO `sys_district` VALUES ('1106', '建瓯市', '121');
INSERT INTO `sys_district` VALUES ('1107', '建阳市', '121');
INSERT INTO `sys_district` VALUES ('1108', '新罗区', '122');
INSERT INTO `sys_district` VALUES ('1109', '长汀县', '122');
INSERT INTO `sys_district` VALUES ('1110', '永定县', '122');
INSERT INTO `sys_district` VALUES ('1111', '上杭县', '122');
INSERT INTO `sys_district` VALUES ('1112', '武平县', '122');
INSERT INTO `sys_district` VALUES ('1113', '连城县', '122');
INSERT INTO `sys_district` VALUES ('1114', '漳平市', '122');
INSERT INTO `sys_district` VALUES ('1115', '蕉城区', '123');
INSERT INTO `sys_district` VALUES ('1116', '霞浦县', '123');
INSERT INTO `sys_district` VALUES ('1117', '古田县', '123');
INSERT INTO `sys_district` VALUES ('1118', '屏南县', '123');
INSERT INTO `sys_district` VALUES ('1119', '寿宁县', '123');
INSERT INTO `sys_district` VALUES ('1120', '周宁县', '123');
INSERT INTO `sys_district` VALUES ('1121', '柘荣县', '123');
INSERT INTO `sys_district` VALUES ('1122', '福安市', '123');
INSERT INTO `sys_district` VALUES ('1123', '福鼎市', '123');
INSERT INTO `sys_district` VALUES ('1124', '东湖区', '124');
INSERT INTO `sys_district` VALUES ('1125', '西湖区', '124');
INSERT INTO `sys_district` VALUES ('1126', '青云谱区', '124');
INSERT INTO `sys_district` VALUES ('1127', '湾里区', '124');
INSERT INTO `sys_district` VALUES ('1128', '青山湖区', '124');
INSERT INTO `sys_district` VALUES ('1129', '南昌县', '124');
INSERT INTO `sys_district` VALUES ('1130', '新建县', '124');
INSERT INTO `sys_district` VALUES ('1131', '安义县', '124');
INSERT INTO `sys_district` VALUES ('1132', '进贤县', '124');
INSERT INTO `sys_district` VALUES ('1133', '昌江区', '125');
INSERT INTO `sys_district` VALUES ('1134', '珠山区', '125');
INSERT INTO `sys_district` VALUES ('1135', '浮梁县', '125');
INSERT INTO `sys_district` VALUES ('1136', '乐平市', '125');
INSERT INTO `sys_district` VALUES ('1137', '安源区', '126');
INSERT INTO `sys_district` VALUES ('1138', '湘东区', '126');
INSERT INTO `sys_district` VALUES ('1139', '莲花县', '126');
INSERT INTO `sys_district` VALUES ('1140', '上栗县', '126');
INSERT INTO `sys_district` VALUES ('1141', '芦溪县', '126');
INSERT INTO `sys_district` VALUES ('1142', '庐山区', '127');
INSERT INTO `sys_district` VALUES ('1143', '浔阳区', '127');
INSERT INTO `sys_district` VALUES ('1144', '九江县', '127');
INSERT INTO `sys_district` VALUES ('1145', '武宁县', '127');
INSERT INTO `sys_district` VALUES ('1146', '修水县', '127');
INSERT INTO `sys_district` VALUES ('1147', '永修县', '127');
INSERT INTO `sys_district` VALUES ('1148', '德安县', '127');
INSERT INTO `sys_district` VALUES ('1149', '星子县', '127');
INSERT INTO `sys_district` VALUES ('1150', '都昌县', '127');
INSERT INTO `sys_district` VALUES ('1151', '湖口县', '127');
INSERT INTO `sys_district` VALUES ('1152', '彭泽县', '127');
INSERT INTO `sys_district` VALUES ('1153', '瑞昌市', '127');
INSERT INTO `sys_district` VALUES ('1154', '渝水区', '128');
INSERT INTO `sys_district` VALUES ('1155', '分宜县', '128');
INSERT INTO `sys_district` VALUES ('1156', '月湖区', '129');
INSERT INTO `sys_district` VALUES ('1157', '余江县', '129');
INSERT INTO `sys_district` VALUES ('1158', '贵溪市', '129');
INSERT INTO `sys_district` VALUES ('1159', '章贡区', '130');
INSERT INTO `sys_district` VALUES ('1160', '赣县', '130');
INSERT INTO `sys_district` VALUES ('1161', '信丰县', '130');
INSERT INTO `sys_district` VALUES ('1162', '大余县', '130');
INSERT INTO `sys_district` VALUES ('1163', '上犹县', '130');
INSERT INTO `sys_district` VALUES ('1164', '崇义县', '130');
INSERT INTO `sys_district` VALUES ('1165', '安远县', '130');
INSERT INTO `sys_district` VALUES ('1166', '龙南县', '130');
INSERT INTO `sys_district` VALUES ('1167', '定南县', '130');
INSERT INTO `sys_district` VALUES ('1168', '全南县', '130');
INSERT INTO `sys_district` VALUES ('1169', '宁都县', '130');
INSERT INTO `sys_district` VALUES ('1170', '于都县', '130');
INSERT INTO `sys_district` VALUES ('1171', '兴国县', '130');
INSERT INTO `sys_district` VALUES ('1172', '会昌县', '130');
INSERT INTO `sys_district` VALUES ('1173', '寻乌县', '130');
INSERT INTO `sys_district` VALUES ('1174', '石城县', '130');
INSERT INTO `sys_district` VALUES ('1175', '瑞金市', '130');
INSERT INTO `sys_district` VALUES ('1176', '南康市', '130');
INSERT INTO `sys_district` VALUES ('1177', '吉州区', '131');
INSERT INTO `sys_district` VALUES ('1178', '青原区', '131');
INSERT INTO `sys_district` VALUES ('1179', '吉安县', '131');
INSERT INTO `sys_district` VALUES ('1180', '吉水县', '131');
INSERT INTO `sys_district` VALUES ('1181', '峡江县', '131');
INSERT INTO `sys_district` VALUES ('1182', '新干县', '131');
INSERT INTO `sys_district` VALUES ('1183', '永丰县', '131');
INSERT INTO `sys_district` VALUES ('1184', '泰和县', '131');
INSERT INTO `sys_district` VALUES ('1185', '遂川县', '131');
INSERT INTO `sys_district` VALUES ('1186', '万安县', '131');
INSERT INTO `sys_district` VALUES ('1187', '安福县', '131');
INSERT INTO `sys_district` VALUES ('1188', '永新县', '131');
INSERT INTO `sys_district` VALUES ('1189', '井冈山市', '131');
INSERT INTO `sys_district` VALUES ('1190', '袁州区', '132');
INSERT INTO `sys_district` VALUES ('1191', '奉新县', '132');
INSERT INTO `sys_district` VALUES ('1192', '万载县', '132');
INSERT INTO `sys_district` VALUES ('1193', '上高县', '132');
INSERT INTO `sys_district` VALUES ('1194', '宜丰县', '132');
INSERT INTO `sys_district` VALUES ('1195', '靖安县', '132');
INSERT INTO `sys_district` VALUES ('1196', '铜鼓县', '132');
INSERT INTO `sys_district` VALUES ('1197', '丰城市', '132');
INSERT INTO `sys_district` VALUES ('1198', '樟树市', '132');
INSERT INTO `sys_district` VALUES ('1199', '高安市', '132');
INSERT INTO `sys_district` VALUES ('1200', '临川区', '133');
INSERT INTO `sys_district` VALUES ('1201', '南城县', '133');
INSERT INTO `sys_district` VALUES ('1202', '黎川县', '133');
INSERT INTO `sys_district` VALUES ('1203', '南丰县', '133');
INSERT INTO `sys_district` VALUES ('1204', '崇仁县', '133');
INSERT INTO `sys_district` VALUES ('1205', '乐安县', '133');
INSERT INTO `sys_district` VALUES ('1206', '宜黄县', '133');
INSERT INTO `sys_district` VALUES ('1207', '金溪县', '133');
INSERT INTO `sys_district` VALUES ('1208', '资溪县', '133');
INSERT INTO `sys_district` VALUES ('1209', '东乡县', '133');
INSERT INTO `sys_district` VALUES ('1210', '广昌县', '133');
INSERT INTO `sys_district` VALUES ('1211', '信州区', '134');
INSERT INTO `sys_district` VALUES ('1212', '上饶县', '134');
INSERT INTO `sys_district` VALUES ('1213', '广丰县', '134');
INSERT INTO `sys_district` VALUES ('1214', '玉山县', '134');
INSERT INTO `sys_district` VALUES ('1215', '铅山县', '134');
INSERT INTO `sys_district` VALUES ('1216', '横峰县', '134');
INSERT INTO `sys_district` VALUES ('1217', '弋阳县', '134');
INSERT INTO `sys_district` VALUES ('1218', '余干县', '134');
INSERT INTO `sys_district` VALUES ('1219', '鄱阳县', '134');
INSERT INTO `sys_district` VALUES ('1220', '万年县', '134');
INSERT INTO `sys_district` VALUES ('1221', '婺源县', '134');
INSERT INTO `sys_district` VALUES ('1222', '德兴市', '134');
INSERT INTO `sys_district` VALUES ('1223', '历下区', '135');
INSERT INTO `sys_district` VALUES ('1224', '市中区', '135');
INSERT INTO `sys_district` VALUES ('1225', '槐荫区', '135');
INSERT INTO `sys_district` VALUES ('1226', '天桥区', '135');
INSERT INTO `sys_district` VALUES ('1227', '历城区', '135');
INSERT INTO `sys_district` VALUES ('1228', '长清区', '135');
INSERT INTO `sys_district` VALUES ('1229', '平阴县', '135');
INSERT INTO `sys_district` VALUES ('1230', '济阳县', '135');
INSERT INTO `sys_district` VALUES ('1231', '商河县', '135');
INSERT INTO `sys_district` VALUES ('1232', '章丘市', '135');
INSERT INTO `sys_district` VALUES ('1233', '市南区', '136');
INSERT INTO `sys_district` VALUES ('1234', '市北区', '136');
INSERT INTO `sys_district` VALUES ('1235', '四方区', '136');
INSERT INTO `sys_district` VALUES ('1236', '黄岛区', '136');
INSERT INTO `sys_district` VALUES ('1237', '崂山区', '136');
INSERT INTO `sys_district` VALUES ('1238', '李沧区', '136');
INSERT INTO `sys_district` VALUES ('1239', '城阳区', '136');
INSERT INTO `sys_district` VALUES ('1240', '胶州市', '136');
INSERT INTO `sys_district` VALUES ('1241', '即墨市', '136');
INSERT INTO `sys_district` VALUES ('1242', '平度市', '136');
INSERT INTO `sys_district` VALUES ('1243', '胶南市', '136');
INSERT INTO `sys_district` VALUES ('1244', '莱西市', '136');
INSERT INTO `sys_district` VALUES ('1245', '淄川区', '137');
INSERT INTO `sys_district` VALUES ('1246', '张店区', '137');
INSERT INTO `sys_district` VALUES ('1247', '博山区', '137');
INSERT INTO `sys_district` VALUES ('1248', '临淄区', '137');
INSERT INTO `sys_district` VALUES ('1249', '周村区', '137');
INSERT INTO `sys_district` VALUES ('1250', '桓台县', '137');
INSERT INTO `sys_district` VALUES ('1251', '高青县', '137');
INSERT INTO `sys_district` VALUES ('1252', '沂源县', '137');
INSERT INTO `sys_district` VALUES ('1253', '市中区', '138');
INSERT INTO `sys_district` VALUES ('1254', '薛城区', '138');
INSERT INTO `sys_district` VALUES ('1255', '峄城区', '138');
INSERT INTO `sys_district` VALUES ('1256', '台儿庄区', '138');
INSERT INTO `sys_district` VALUES ('1257', '山亭区', '138');
INSERT INTO `sys_district` VALUES ('1258', '滕州市', '138');
INSERT INTO `sys_district` VALUES ('1259', '东营区', '139');
INSERT INTO `sys_district` VALUES ('1260', '河口区', '139');
INSERT INTO `sys_district` VALUES ('1261', '垦利县', '139');
INSERT INTO `sys_district` VALUES ('1262', '利津县', '139');
INSERT INTO `sys_district` VALUES ('1263', '广饶县', '139');
INSERT INTO `sys_district` VALUES ('1264', '芝罘区', '140');
INSERT INTO `sys_district` VALUES ('1265', '福山区', '140');
INSERT INTO `sys_district` VALUES ('1266', '牟平区', '140');
INSERT INTO `sys_district` VALUES ('1267', '莱山区', '140');
INSERT INTO `sys_district` VALUES ('1268', '长岛县', '140');
INSERT INTO `sys_district` VALUES ('1269', '龙口市', '140');
INSERT INTO `sys_district` VALUES ('1270', '莱阳市', '140');
INSERT INTO `sys_district` VALUES ('1271', '莱州市', '140');
INSERT INTO `sys_district` VALUES ('1272', '蓬莱市', '140');
INSERT INTO `sys_district` VALUES ('1273', '招远市', '140');
INSERT INTO `sys_district` VALUES ('1274', '栖霞市', '140');
INSERT INTO `sys_district` VALUES ('1275', '海阳市', '140');
INSERT INTO `sys_district` VALUES ('1276', '潍城区', '141');
INSERT INTO `sys_district` VALUES ('1277', '寒亭区', '141');
INSERT INTO `sys_district` VALUES ('1278', '坊子区', '141');
INSERT INTO `sys_district` VALUES ('1279', '奎文区', '141');
INSERT INTO `sys_district` VALUES ('1280', '临朐县', '141');
INSERT INTO `sys_district` VALUES ('1281', '昌乐县', '141');
INSERT INTO `sys_district` VALUES ('1282', '青州市', '141');
INSERT INTO `sys_district` VALUES ('1283', '诸城市', '141');
INSERT INTO `sys_district` VALUES ('1284', '寿光市', '141');
INSERT INTO `sys_district` VALUES ('1285', '安丘市', '141');
INSERT INTO `sys_district` VALUES ('1286', '高密市', '141');
INSERT INTO `sys_district` VALUES ('1287', '昌邑市', '141');
INSERT INTO `sys_district` VALUES ('1288', '市中区', '142');
INSERT INTO `sys_district` VALUES ('1289', '任城区', '142');
INSERT INTO `sys_district` VALUES ('1290', '微山县', '142');
INSERT INTO `sys_district` VALUES ('1291', '鱼台县', '142');
INSERT INTO `sys_district` VALUES ('1292', '金乡县', '142');
INSERT INTO `sys_district` VALUES ('1293', '嘉祥县', '142');
INSERT INTO `sys_district` VALUES ('1294', '汶上县', '142');
INSERT INTO `sys_district` VALUES ('1295', '泗水县', '142');
INSERT INTO `sys_district` VALUES ('1296', '梁山县', '142');
INSERT INTO `sys_district` VALUES ('1297', '曲阜市', '142');
INSERT INTO `sys_district` VALUES ('1298', '兖州市', '142');
INSERT INTO `sys_district` VALUES ('1299', '邹城市', '142');
INSERT INTO `sys_district` VALUES ('1300', '泰山区', '143');
INSERT INTO `sys_district` VALUES ('1301', '岱岳区', '143');
INSERT INTO `sys_district` VALUES ('1302', '宁阳县', '143');
INSERT INTO `sys_district` VALUES ('1303', '东平县', '143');
INSERT INTO `sys_district` VALUES ('1304', '新泰市', '143');
INSERT INTO `sys_district` VALUES ('1305', '肥城市', '143');
INSERT INTO `sys_district` VALUES ('1306', '环翠区', '144');
INSERT INTO `sys_district` VALUES ('1307', '文登市', '144');
INSERT INTO `sys_district` VALUES ('1308', '荣成市', '144');
INSERT INTO `sys_district` VALUES ('1309', '乳山市', '144');
INSERT INTO `sys_district` VALUES ('1310', '东港区', '145');
INSERT INTO `sys_district` VALUES ('1311', '岚山区', '145');
INSERT INTO `sys_district` VALUES ('1312', '五莲县', '145');
INSERT INTO `sys_district` VALUES ('1313', '莒县', '145');
INSERT INTO `sys_district` VALUES ('1314', '莱城区', '146');
INSERT INTO `sys_district` VALUES ('1315', '钢城区', '146');
INSERT INTO `sys_district` VALUES ('1316', '兰山区', '147');
INSERT INTO `sys_district` VALUES ('1317', '罗庄区', '147');
INSERT INTO `sys_district` VALUES ('1318', '河东区', '147');
INSERT INTO `sys_district` VALUES ('1319', '沂南县', '147');
INSERT INTO `sys_district` VALUES ('1320', '郯城县', '147');
INSERT INTO `sys_district` VALUES ('1321', '沂水县', '147');
INSERT INTO `sys_district` VALUES ('1322', '苍山县', '147');
INSERT INTO `sys_district` VALUES ('1323', '费县', '147');
INSERT INTO `sys_district` VALUES ('1324', '平邑县', '147');
INSERT INTO `sys_district` VALUES ('1325', '莒南县', '147');
INSERT INTO `sys_district` VALUES ('1326', '蒙阴县', '147');
INSERT INTO `sys_district` VALUES ('1327', '临沭县', '147');
INSERT INTO `sys_district` VALUES ('1328', '德城区', '148');
INSERT INTO `sys_district` VALUES ('1329', '陵县', '148');
INSERT INTO `sys_district` VALUES ('1330', '宁津县', '148');
INSERT INTO `sys_district` VALUES ('1331', '庆云县', '148');
INSERT INTO `sys_district` VALUES ('1332', '临邑县', '148');
INSERT INTO `sys_district` VALUES ('1333', '齐河县', '148');
INSERT INTO `sys_district` VALUES ('1334', '平原县', '148');
INSERT INTO `sys_district` VALUES ('1335', '夏津县', '148');
INSERT INTO `sys_district` VALUES ('1336', '武城县', '148');
INSERT INTO `sys_district` VALUES ('1337', '乐陵市', '148');
INSERT INTO `sys_district` VALUES ('1338', '禹城市', '148');
INSERT INTO `sys_district` VALUES ('1339', '东昌府区', '149');
INSERT INTO `sys_district` VALUES ('1340', '阳谷县', '149');
INSERT INTO `sys_district` VALUES ('1341', '莘县', '149');
INSERT INTO `sys_district` VALUES ('1342', '茌平县', '149');
INSERT INTO `sys_district` VALUES ('1343', '东阿县', '149');
INSERT INTO `sys_district` VALUES ('1344', '冠县', '149');
INSERT INTO `sys_district` VALUES ('1345', '高唐县', '149');
INSERT INTO `sys_district` VALUES ('1346', '临清市', '149');
INSERT INTO `sys_district` VALUES ('1347', '滨城区', '150');
INSERT INTO `sys_district` VALUES ('1348', '惠民县', '150');
INSERT INTO `sys_district` VALUES ('1349', '阳信县', '150');
INSERT INTO `sys_district` VALUES ('1350', '无棣县', '150');
INSERT INTO `sys_district` VALUES ('1351', '沾化县', '150');
INSERT INTO `sys_district` VALUES ('1352', '博兴县', '150');
INSERT INTO `sys_district` VALUES ('1353', '邹平县', '150');
INSERT INTO `sys_district` VALUES ('1354', '牡丹区', '151');
INSERT INTO `sys_district` VALUES ('1355', '曹县', '151');
INSERT INTO `sys_district` VALUES ('1356', '单县', '151');
INSERT INTO `sys_district` VALUES ('1357', '成武县', '151');
INSERT INTO `sys_district` VALUES ('1358', '巨野县', '151');
INSERT INTO `sys_district` VALUES ('1359', '郓城县', '151');
INSERT INTO `sys_district` VALUES ('1360', '鄄城县', '151');
INSERT INTO `sys_district` VALUES ('1361', '定陶县', '151');
INSERT INTO `sys_district` VALUES ('1362', '东明县', '151');
INSERT INTO `sys_district` VALUES ('1363', '中原区', '152');
INSERT INTO `sys_district` VALUES ('1364', '二七区', '152');
INSERT INTO `sys_district` VALUES ('1365', '管城回族区', '152');
INSERT INTO `sys_district` VALUES ('1366', '金水区', '152');
INSERT INTO `sys_district` VALUES ('1367', '上街区', '152');
INSERT INTO `sys_district` VALUES ('1368', '惠济区', '152');
INSERT INTO `sys_district` VALUES ('1369', '中牟县', '152');
INSERT INTO `sys_district` VALUES ('1370', '巩义市', '152');
INSERT INTO `sys_district` VALUES ('1371', '荥阳市', '152');
INSERT INTO `sys_district` VALUES ('1372', '新密市', '152');
INSERT INTO `sys_district` VALUES ('1373', '新郑市', '152');
INSERT INTO `sys_district` VALUES ('1374', '登封市', '152');
INSERT INTO `sys_district` VALUES ('1375', '龙亭区', '153');
INSERT INTO `sys_district` VALUES ('1376', '顺河回族区', '153');
INSERT INTO `sys_district` VALUES ('1377', '鼓楼区', '153');
INSERT INTO `sys_district` VALUES ('1378', '南关区', '153');
INSERT INTO `sys_district` VALUES ('1379', '郊区', '153');
INSERT INTO `sys_district` VALUES ('1380', '杞县', '153');
INSERT INTO `sys_district` VALUES ('1381', '通许县', '153');
INSERT INTO `sys_district` VALUES ('1382', '尉氏县', '153');
INSERT INTO `sys_district` VALUES ('1383', '开封县', '153');
INSERT INTO `sys_district` VALUES ('1384', '兰考县', '153');
INSERT INTO `sys_district` VALUES ('1385', '老城区', '154');
INSERT INTO `sys_district` VALUES ('1386', '西工区', '154');
INSERT INTO `sys_district` VALUES ('1387', '廛河回族区', '154');
INSERT INTO `sys_district` VALUES ('1388', '涧西区', '154');
INSERT INTO `sys_district` VALUES ('1389', '吉利区', '154');
INSERT INTO `sys_district` VALUES ('1390', '洛龙区', '154');
INSERT INTO `sys_district` VALUES ('1391', '孟津县', '154');
INSERT INTO `sys_district` VALUES ('1392', '新安县', '154');
INSERT INTO `sys_district` VALUES ('1393', '栾川县', '154');
INSERT INTO `sys_district` VALUES ('1394', '嵩县', '154');
INSERT INTO `sys_district` VALUES ('1395', '汝阳县', '154');
INSERT INTO `sys_district` VALUES ('1396', '宜阳县', '154');
INSERT INTO `sys_district` VALUES ('1397', '洛宁县', '154');
INSERT INTO `sys_district` VALUES ('1398', '伊川县', '154');
INSERT INTO `sys_district` VALUES ('1399', '偃师市', '154');
INSERT INTO `sys_district` VALUES ('1400', '新华区', '155');
INSERT INTO `sys_district` VALUES ('1401', '卫东区', '155');
INSERT INTO `sys_district` VALUES ('1402', '石龙区', '155');
INSERT INTO `sys_district` VALUES ('1403', '湛河区', '155');
INSERT INTO `sys_district` VALUES ('1404', '宝丰县', '155');
INSERT INTO `sys_district` VALUES ('1405', '叶县', '155');
INSERT INTO `sys_district` VALUES ('1406', '鲁山县', '155');
INSERT INTO `sys_district` VALUES ('1407', '郏县', '155');
INSERT INTO `sys_district` VALUES ('1408', '舞钢市', '155');
INSERT INTO `sys_district` VALUES ('1409', '汝州市', '155');
INSERT INTO `sys_district` VALUES ('1410', '文峰区', '156');
INSERT INTO `sys_district` VALUES ('1411', '北关区', '156');
INSERT INTO `sys_district` VALUES ('1412', '殷都区', '156');
INSERT INTO `sys_district` VALUES ('1413', '龙安区', '156');
INSERT INTO `sys_district` VALUES ('1414', '安阳县', '156');
INSERT INTO `sys_district` VALUES ('1415', '汤阴县', '156');
INSERT INTO `sys_district` VALUES ('1416', '滑县', '156');
INSERT INTO `sys_district` VALUES ('1417', '内黄县', '156');
INSERT INTO `sys_district` VALUES ('1418', '林州市', '156');
INSERT INTO `sys_district` VALUES ('1419', '鹤山区', '157');
INSERT INTO `sys_district` VALUES ('1420', '山城区', '157');
INSERT INTO `sys_district` VALUES ('1421', '淇滨区', '157');
INSERT INTO `sys_district` VALUES ('1422', '浚县', '157');
INSERT INTO `sys_district` VALUES ('1423', '淇县', '157');
INSERT INTO `sys_district` VALUES ('1424', '红旗区', '158');
INSERT INTO `sys_district` VALUES ('1425', '卫滨区', '158');
INSERT INTO `sys_district` VALUES ('1426', '凤泉区', '158');
INSERT INTO `sys_district` VALUES ('1427', '牧野区', '158');
INSERT INTO `sys_district` VALUES ('1428', '新乡县', '158');
INSERT INTO `sys_district` VALUES ('1429', '获嘉县', '158');
INSERT INTO `sys_district` VALUES ('1430', '原阳县', '158');
INSERT INTO `sys_district` VALUES ('1431', '延津县', '158');
INSERT INTO `sys_district` VALUES ('1432', '封丘县', '158');
INSERT INTO `sys_district` VALUES ('1433', '长垣县', '158');
INSERT INTO `sys_district` VALUES ('1434', '卫辉市', '158');
INSERT INTO `sys_district` VALUES ('1435', '辉县市', '158');
INSERT INTO `sys_district` VALUES ('1436', '解放区', '159');
INSERT INTO `sys_district` VALUES ('1437', '中站区', '159');
INSERT INTO `sys_district` VALUES ('1438', '马村区', '159');
INSERT INTO `sys_district` VALUES ('1439', '山阳区', '159');
INSERT INTO `sys_district` VALUES ('1440', '修武县', '159');
INSERT INTO `sys_district` VALUES ('1441', '博爱县', '159');
INSERT INTO `sys_district` VALUES ('1442', '武陟县', '159');
INSERT INTO `sys_district` VALUES ('1443', '温县', '159');
INSERT INTO `sys_district` VALUES ('1444', '济源市', '159');
INSERT INTO `sys_district` VALUES ('1445', '沁阳市', '159');
INSERT INTO `sys_district` VALUES ('1446', '孟州市', '159');
INSERT INTO `sys_district` VALUES ('1447', '华龙区', '160');
INSERT INTO `sys_district` VALUES ('1448', '清丰县', '160');
INSERT INTO `sys_district` VALUES ('1449', '南乐县', '160');
INSERT INTO `sys_district` VALUES ('1450', '范县', '160');
INSERT INTO `sys_district` VALUES ('1451', '台前县', '160');
INSERT INTO `sys_district` VALUES ('1452', '濮阳县', '160');
INSERT INTO `sys_district` VALUES ('1453', '魏都区', '161');
INSERT INTO `sys_district` VALUES ('1454', '许昌县', '161');
INSERT INTO `sys_district` VALUES ('1455', '鄢陵县', '161');
INSERT INTO `sys_district` VALUES ('1456', '襄城县', '161');
INSERT INTO `sys_district` VALUES ('1457', '禹州市', '161');
INSERT INTO `sys_district` VALUES ('1458', '长葛市', '161');
INSERT INTO `sys_district` VALUES ('1459', '源汇区', '162');
INSERT INTO `sys_district` VALUES ('1460', '郾城区', '162');
INSERT INTO `sys_district` VALUES ('1461', '召陵区', '162');
INSERT INTO `sys_district` VALUES ('1462', '舞阳县', '162');
INSERT INTO `sys_district` VALUES ('1463', '临颍县', '162');
INSERT INTO `sys_district` VALUES ('1464', '市辖区', '163');
INSERT INTO `sys_district` VALUES ('1465', '湖滨区', '163');
INSERT INTO `sys_district` VALUES ('1466', '渑池县', '163');
INSERT INTO `sys_district` VALUES ('1467', '陕县', '163');
INSERT INTO `sys_district` VALUES ('1468', '卢氏县', '163');
INSERT INTO `sys_district` VALUES ('1469', '义马市', '163');
INSERT INTO `sys_district` VALUES ('1470', '灵宝市', '163');
INSERT INTO `sys_district` VALUES ('1471', '宛城区', '164');
INSERT INTO `sys_district` VALUES ('1472', '卧龙区', '164');
INSERT INTO `sys_district` VALUES ('1473', '南召县', '164');
INSERT INTO `sys_district` VALUES ('1474', '方城县', '164');
INSERT INTO `sys_district` VALUES ('1475', '西峡县', '164');
INSERT INTO `sys_district` VALUES ('1476', '镇平县', '164');
INSERT INTO `sys_district` VALUES ('1477', '内乡县', '164');
INSERT INTO `sys_district` VALUES ('1478', '淅川县', '164');
INSERT INTO `sys_district` VALUES ('1479', '社旗县', '164');
INSERT INTO `sys_district` VALUES ('1480', '唐河县', '164');
INSERT INTO `sys_district` VALUES ('1481', '新野县', '164');
INSERT INTO `sys_district` VALUES ('1482', '桐柏县', '164');
INSERT INTO `sys_district` VALUES ('1483', '邓州市', '164');
INSERT INTO `sys_district` VALUES ('1484', '梁园区', '165');
INSERT INTO `sys_district` VALUES ('1485', '睢阳区', '165');
INSERT INTO `sys_district` VALUES ('1486', '民权县', '165');
INSERT INTO `sys_district` VALUES ('1487', '睢县', '165');
INSERT INTO `sys_district` VALUES ('1488', '宁陵县', '165');
INSERT INTO `sys_district` VALUES ('1489', '柘城县', '165');
INSERT INTO `sys_district` VALUES ('1490', '虞城县', '165');
INSERT INTO `sys_district` VALUES ('1491', '夏邑县', '165');
INSERT INTO `sys_district` VALUES ('1492', '永城市', '165');
INSERT INTO `sys_district` VALUES ('1493', '浉河区', '166');
INSERT INTO `sys_district` VALUES ('1494', '平桥区', '166');
INSERT INTO `sys_district` VALUES ('1495', '罗山县', '166');
INSERT INTO `sys_district` VALUES ('1496', '光山县', '166');
INSERT INTO `sys_district` VALUES ('1497', '新县', '166');
INSERT INTO `sys_district` VALUES ('1498', '商城县', '166');
INSERT INTO `sys_district` VALUES ('1499', '固始县', '166');
INSERT INTO `sys_district` VALUES ('1500', '潢川县', '166');
INSERT INTO `sys_district` VALUES ('1501', '淮滨县', '166');
INSERT INTO `sys_district` VALUES ('1502', '息县', '166');
INSERT INTO `sys_district` VALUES ('1503', '川汇区', '167');
INSERT INTO `sys_district` VALUES ('1504', '扶沟县', '167');
INSERT INTO `sys_district` VALUES ('1505', '西华县', '167');
INSERT INTO `sys_district` VALUES ('1506', '商水县', '167');
INSERT INTO `sys_district` VALUES ('1507', '沈丘县', '167');
INSERT INTO `sys_district` VALUES ('1508', '郸城县', '167');
INSERT INTO `sys_district` VALUES ('1509', '淮阳县', '167');
INSERT INTO `sys_district` VALUES ('1510', '太康县', '167');
INSERT INTO `sys_district` VALUES ('1511', '鹿邑县', '167');
INSERT INTO `sys_district` VALUES ('1512', '项城市', '167');
INSERT INTO `sys_district` VALUES ('1513', '驿城区', '168');
INSERT INTO `sys_district` VALUES ('1514', '西平县', '168');
INSERT INTO `sys_district` VALUES ('1515', '上蔡县', '168');
INSERT INTO `sys_district` VALUES ('1516', '平舆县', '168');
INSERT INTO `sys_district` VALUES ('1517', '正阳县', '168');
INSERT INTO `sys_district` VALUES ('1518', '确山县', '168');
INSERT INTO `sys_district` VALUES ('1519', '泌阳县', '168');
INSERT INTO `sys_district` VALUES ('1520', '汝南县', '168');
INSERT INTO `sys_district` VALUES ('1521', '遂平县', '168');
INSERT INTO `sys_district` VALUES ('1522', '新蔡县', '168');
INSERT INTO `sys_district` VALUES ('1523', '江岸区', '169');
INSERT INTO `sys_district` VALUES ('1524', '江汉区', '169');
INSERT INTO `sys_district` VALUES ('1525', '硚口区', '169');
INSERT INTO `sys_district` VALUES ('1526', '汉阳区', '169');
INSERT INTO `sys_district` VALUES ('1527', '武昌区', '169');
INSERT INTO `sys_district` VALUES ('1528', '青山区', '169');
INSERT INTO `sys_district` VALUES ('1529', '洪山区', '169');
INSERT INTO `sys_district` VALUES ('1530', '东西湖区', '169');
INSERT INTO `sys_district` VALUES ('1531', '汉南区', '169');
INSERT INTO `sys_district` VALUES ('1532', '蔡甸区', '169');
INSERT INTO `sys_district` VALUES ('1533', '江夏区', '169');
INSERT INTO `sys_district` VALUES ('1534', '黄陂区', '169');
INSERT INTO `sys_district` VALUES ('1535', '新洲区', '169');
INSERT INTO `sys_district` VALUES ('1536', '黄石港区', '170');
INSERT INTO `sys_district` VALUES ('1537', '西塞山区', '170');
INSERT INTO `sys_district` VALUES ('1538', '下陆区', '170');
INSERT INTO `sys_district` VALUES ('1539', '铁山区', '170');
INSERT INTO `sys_district` VALUES ('1540', '阳新县', '170');
INSERT INTO `sys_district` VALUES ('1541', '大冶市', '170');
INSERT INTO `sys_district` VALUES ('1542', '茅箭区', '171');
INSERT INTO `sys_district` VALUES ('1543', '张湾区', '171');
INSERT INTO `sys_district` VALUES ('1544', '郧县', '171');
INSERT INTO `sys_district` VALUES ('1545', '郧西县', '171');
INSERT INTO `sys_district` VALUES ('1546', '竹山县', '171');
INSERT INTO `sys_district` VALUES ('1547', '竹溪县', '171');
INSERT INTO `sys_district` VALUES ('1548', '房县', '171');
INSERT INTO `sys_district` VALUES ('1549', '丹江口市', '171');
INSERT INTO `sys_district` VALUES ('1550', '西陵区', '172');
INSERT INTO `sys_district` VALUES ('1551', '伍家岗区', '172');
INSERT INTO `sys_district` VALUES ('1552', '点军区', '172');
INSERT INTO `sys_district` VALUES ('1553', '猇亭区', '172');
INSERT INTO `sys_district` VALUES ('1554', '夷陵区', '172');
INSERT INTO `sys_district` VALUES ('1555', '远安县', '172');
INSERT INTO `sys_district` VALUES ('1556', '兴山县', '172');
INSERT INTO `sys_district` VALUES ('1557', '秭归县', '172');
INSERT INTO `sys_district` VALUES ('1558', '长阳土家族自治县', '172');
INSERT INTO `sys_district` VALUES ('1559', '五峰土家族自治县', '172');
INSERT INTO `sys_district` VALUES ('1560', '宜都市', '172');
INSERT INTO `sys_district` VALUES ('1561', '当阳市', '172');
INSERT INTO `sys_district` VALUES ('1562', '枝江市', '172');
INSERT INTO `sys_district` VALUES ('1563', '襄城区', '173');
INSERT INTO `sys_district` VALUES ('1564', '樊城区', '173');
INSERT INTO `sys_district` VALUES ('1565', '襄阳区', '173');
INSERT INTO `sys_district` VALUES ('1566', '南漳县', '173');
INSERT INTO `sys_district` VALUES ('1567', '谷城县', '173');
INSERT INTO `sys_district` VALUES ('1568', '保康县', '173');
INSERT INTO `sys_district` VALUES ('1569', '老河口市', '173');
INSERT INTO `sys_district` VALUES ('1570', '枣阳市', '173');
INSERT INTO `sys_district` VALUES ('1571', '宜城市', '173');
INSERT INTO `sys_district` VALUES ('1572', '梁子湖区', '174');
INSERT INTO `sys_district` VALUES ('1573', '华容区', '174');
INSERT INTO `sys_district` VALUES ('1574', '鄂城区', '174');
INSERT INTO `sys_district` VALUES ('1575', '东宝区', '175');
INSERT INTO `sys_district` VALUES ('1576', '掇刀区', '175');
INSERT INTO `sys_district` VALUES ('1577', '京山县', '175');
INSERT INTO `sys_district` VALUES ('1578', '沙洋县', '175');
INSERT INTO `sys_district` VALUES ('1579', '钟祥市', '175');
INSERT INTO `sys_district` VALUES ('1580', '孝南区', '176');
INSERT INTO `sys_district` VALUES ('1581', '孝昌县', '176');
INSERT INTO `sys_district` VALUES ('1582', '大悟县', '176');
INSERT INTO `sys_district` VALUES ('1583', '云梦县', '176');
INSERT INTO `sys_district` VALUES ('1584', '应城市', '176');
INSERT INTO `sys_district` VALUES ('1585', '安陆市', '176');
INSERT INTO `sys_district` VALUES ('1586', '汉川市', '176');
INSERT INTO `sys_district` VALUES ('1587', '沙市区', '177');
INSERT INTO `sys_district` VALUES ('1588', '荆州区', '177');
INSERT INTO `sys_district` VALUES ('1589', '公安县', '177');
INSERT INTO `sys_district` VALUES ('1590', '监利县', '177');
INSERT INTO `sys_district` VALUES ('1591', '江陵县', '177');
INSERT INTO `sys_district` VALUES ('1592', '石首市', '177');
INSERT INTO `sys_district` VALUES ('1593', '洪湖市', '177');
INSERT INTO `sys_district` VALUES ('1594', '松滋市', '177');
INSERT INTO `sys_district` VALUES ('1595', '黄州区', '178');
INSERT INTO `sys_district` VALUES ('1596', '团风县', '178');
INSERT INTO `sys_district` VALUES ('1597', '红安县', '178');
INSERT INTO `sys_district` VALUES ('1598', '罗田县', '178');
INSERT INTO `sys_district` VALUES ('1599', '英山县', '178');
INSERT INTO `sys_district` VALUES ('1600', '浠水县', '178');
INSERT INTO `sys_district` VALUES ('1601', '蕲春县', '178');
INSERT INTO `sys_district` VALUES ('1602', '黄梅县', '178');
INSERT INTO `sys_district` VALUES ('1603', '麻城市', '178');
INSERT INTO `sys_district` VALUES ('1604', '武穴市', '178');
INSERT INTO `sys_district` VALUES ('1605', '咸安区', '179');
INSERT INTO `sys_district` VALUES ('1606', '嘉鱼县', '179');
INSERT INTO `sys_district` VALUES ('1607', '通城县', '179');
INSERT INTO `sys_district` VALUES ('1608', '崇阳县', '179');
INSERT INTO `sys_district` VALUES ('1609', '通山县', '179');
INSERT INTO `sys_district` VALUES ('1610', '赤壁市', '179');
INSERT INTO `sys_district` VALUES ('1611', '曾都区', '180');
INSERT INTO `sys_district` VALUES ('1612', '广水市', '180');
INSERT INTO `sys_district` VALUES ('1613', '恩施市', '181');
INSERT INTO `sys_district` VALUES ('1614', '利川市', '181');
INSERT INTO `sys_district` VALUES ('1615', '建始县', '181');
INSERT INTO `sys_district` VALUES ('1616', '巴东县', '181');
INSERT INTO `sys_district` VALUES ('1617', '宣恩县', '181');
INSERT INTO `sys_district` VALUES ('1618', '咸丰县', '181');
INSERT INTO `sys_district` VALUES ('1619', '来凤县', '181');
INSERT INTO `sys_district` VALUES ('1620', '鹤峰县', '181');
INSERT INTO `sys_district` VALUES ('1621', '仙桃市', '182');
INSERT INTO `sys_district` VALUES ('1622', '潜江市', '182');
INSERT INTO `sys_district` VALUES ('1623', '天门市', '182');
INSERT INTO `sys_district` VALUES ('1624', '神农架林区', '182');
INSERT INTO `sys_district` VALUES ('1625', '芙蓉区', '183');
INSERT INTO `sys_district` VALUES ('1626', '天心区', '183');
INSERT INTO `sys_district` VALUES ('1627', '岳麓区', '183');
INSERT INTO `sys_district` VALUES ('1628', '开福区', '183');
INSERT INTO `sys_district` VALUES ('1629', '雨花区', '183');
INSERT INTO `sys_district` VALUES ('1630', '长沙县', '183');
INSERT INTO `sys_district` VALUES ('1631', '望城县', '183');
INSERT INTO `sys_district` VALUES ('1632', '宁乡县', '183');
INSERT INTO `sys_district` VALUES ('1633', '浏阳市', '183');
INSERT INTO `sys_district` VALUES ('1634', '荷塘区', '184');
INSERT INTO `sys_district` VALUES ('1635', '芦淞区', '184');
INSERT INTO `sys_district` VALUES ('1636', '石峰区', '184');
INSERT INTO `sys_district` VALUES ('1637', '天元区', '184');
INSERT INTO `sys_district` VALUES ('1638', '株洲县', '184');
INSERT INTO `sys_district` VALUES ('1639', '攸县', '184');
INSERT INTO `sys_district` VALUES ('1640', '茶陵县', '184');
INSERT INTO `sys_district` VALUES ('1641', '炎陵县', '184');
INSERT INTO `sys_district` VALUES ('1642', '醴陵市', '184');
INSERT INTO `sys_district` VALUES ('1643', '雨湖区', '185');
INSERT INTO `sys_district` VALUES ('1644', '岳塘区', '185');
INSERT INTO `sys_district` VALUES ('1645', '湘潭县', '185');
INSERT INTO `sys_district` VALUES ('1646', '湘乡市', '185');
INSERT INTO `sys_district` VALUES ('1647', '韶山市', '185');
INSERT INTO `sys_district` VALUES ('1648', '珠晖区', '186');
INSERT INTO `sys_district` VALUES ('1649', '雁峰区', '186');
INSERT INTO `sys_district` VALUES ('1650', '石鼓区', '186');
INSERT INTO `sys_district` VALUES ('1651', '蒸湘区', '186');
INSERT INTO `sys_district` VALUES ('1652', '南岳区', '186');
INSERT INTO `sys_district` VALUES ('1653', '衡阳县', '186');
INSERT INTO `sys_district` VALUES ('1654', '衡南县', '186');
INSERT INTO `sys_district` VALUES ('1655', '衡山县', '186');
INSERT INTO `sys_district` VALUES ('1656', '衡东县', '186');
INSERT INTO `sys_district` VALUES ('1657', '祁东县', '186');
INSERT INTO `sys_district` VALUES ('1658', '耒阳市', '186');
INSERT INTO `sys_district` VALUES ('1659', '常宁市', '186');
INSERT INTO `sys_district` VALUES ('1660', '双清区', '187');
INSERT INTO `sys_district` VALUES ('1661', '大祥区', '187');
INSERT INTO `sys_district` VALUES ('1662', '北塔区', '187');
INSERT INTO `sys_district` VALUES ('1663', '邵东县', '187');
INSERT INTO `sys_district` VALUES ('1664', '新邵县', '187');
INSERT INTO `sys_district` VALUES ('1665', '邵阳县', '187');
INSERT INTO `sys_district` VALUES ('1666', '隆回县', '187');
INSERT INTO `sys_district` VALUES ('1667', '洞口县', '187');
INSERT INTO `sys_district` VALUES ('1668', '绥宁县', '187');
INSERT INTO `sys_district` VALUES ('1669', '新宁县', '187');
INSERT INTO `sys_district` VALUES ('1670', '城步苗族自治县', '187');
INSERT INTO `sys_district` VALUES ('1671', '武冈市', '187');
INSERT INTO `sys_district` VALUES ('1672', '岳阳楼区', '188');
INSERT INTO `sys_district` VALUES ('1673', '云溪区', '188');
INSERT INTO `sys_district` VALUES ('1674', '君山区', '188');
INSERT INTO `sys_district` VALUES ('1675', '岳阳县', '188');
INSERT INTO `sys_district` VALUES ('1676', '华容县', '188');
INSERT INTO `sys_district` VALUES ('1677', '湘阴县', '188');
INSERT INTO `sys_district` VALUES ('1678', '平江县', '188');
INSERT INTO `sys_district` VALUES ('1679', '汨罗市', '188');
INSERT INTO `sys_district` VALUES ('1680', '临湘市', '188');
INSERT INTO `sys_district` VALUES ('1681', '武陵区', '189');
INSERT INTO `sys_district` VALUES ('1682', '鼎城区', '189');
INSERT INTO `sys_district` VALUES ('1683', '安乡县', '189');
INSERT INTO `sys_district` VALUES ('1684', '汉寿县', '189');
INSERT INTO `sys_district` VALUES ('1685', '澧县', '189');
INSERT INTO `sys_district` VALUES ('1686', '临澧县', '189');
INSERT INTO `sys_district` VALUES ('1687', '桃源县', '189');
INSERT INTO `sys_district` VALUES ('1688', '石门县', '189');
INSERT INTO `sys_district` VALUES ('1689', '津市市', '189');
INSERT INTO `sys_district` VALUES ('1690', '永定区', '190');
INSERT INTO `sys_district` VALUES ('1691', '武陵源区', '190');
INSERT INTO `sys_district` VALUES ('1692', '慈利县', '190');
INSERT INTO `sys_district` VALUES ('1693', '桑植县', '190');
INSERT INTO `sys_district` VALUES ('1694', '资阳区', '191');
INSERT INTO `sys_district` VALUES ('1695', '赫山区', '191');
INSERT INTO `sys_district` VALUES ('1696', '南县', '191');
INSERT INTO `sys_district` VALUES ('1697', '桃江县', '191');
INSERT INTO `sys_district` VALUES ('1698', '安化县', '191');
INSERT INTO `sys_district` VALUES ('1699', '沅江市', '191');
INSERT INTO `sys_district` VALUES ('1700', '北湖区', '192');
INSERT INTO `sys_district` VALUES ('1701', '苏仙区', '192');
INSERT INTO `sys_district` VALUES ('1702', '桂阳县', '192');
INSERT INTO `sys_district` VALUES ('1703', '宜章县', '192');
INSERT INTO `sys_district` VALUES ('1704', '永兴县', '192');
INSERT INTO `sys_district` VALUES ('1705', '嘉禾县', '192');
INSERT INTO `sys_district` VALUES ('1706', '临武县', '192');
INSERT INTO `sys_district` VALUES ('1707', '汝城县', '192');
INSERT INTO `sys_district` VALUES ('1708', '桂东县', '192');
INSERT INTO `sys_district` VALUES ('1709', '安仁县', '192');
INSERT INTO `sys_district` VALUES ('1710', '资兴市', '192');
INSERT INTO `sys_district` VALUES ('1711', '芝山区', '193');
INSERT INTO `sys_district` VALUES ('1712', '冷水滩区', '193');
INSERT INTO `sys_district` VALUES ('1713', '祁阳县', '193');
INSERT INTO `sys_district` VALUES ('1714', '东安县', '193');
INSERT INTO `sys_district` VALUES ('1715', '双牌县', '193');
INSERT INTO `sys_district` VALUES ('1716', '道县', '193');
INSERT INTO `sys_district` VALUES ('1717', '江永县', '193');
INSERT INTO `sys_district` VALUES ('1718', '宁远县', '193');
INSERT INTO `sys_district` VALUES ('1719', '蓝山县', '193');
INSERT INTO `sys_district` VALUES ('1720', '新田县', '193');
INSERT INTO `sys_district` VALUES ('1721', '江华瑶族自治县', '193');
INSERT INTO `sys_district` VALUES ('1722', '鹤城区', '194');
INSERT INTO `sys_district` VALUES ('1723', '中方县', '194');
INSERT INTO `sys_district` VALUES ('1724', '沅陵县', '194');
INSERT INTO `sys_district` VALUES ('1725', '辰溪县', '194');
INSERT INTO `sys_district` VALUES ('1726', '溆浦县', '194');
INSERT INTO `sys_district` VALUES ('1727', '会同县', '194');
INSERT INTO `sys_district` VALUES ('1728', '麻阳苗族自治县', '194');
INSERT INTO `sys_district` VALUES ('1729', '新晃侗族自治县', '194');
INSERT INTO `sys_district` VALUES ('1730', '芷江侗族自治县', '194');
INSERT INTO `sys_district` VALUES ('1731', '靖州苗族侗族自治县', '194');
INSERT INTO `sys_district` VALUES ('1732', '通道侗族自治县', '194');
INSERT INTO `sys_district` VALUES ('1733', '洪江市', '194');
INSERT INTO `sys_district` VALUES ('1734', '娄星区', '195');
INSERT INTO `sys_district` VALUES ('1735', '双峰县', '195');
INSERT INTO `sys_district` VALUES ('1736', '新化县', '195');
INSERT INTO `sys_district` VALUES ('1737', '冷水江市', '195');
INSERT INTO `sys_district` VALUES ('1738', '涟源市', '195');
INSERT INTO `sys_district` VALUES ('1739', '吉首市', '196');
INSERT INTO `sys_district` VALUES ('1740', '泸溪县', '196');
INSERT INTO `sys_district` VALUES ('1741', '凤凰县', '196');
INSERT INTO `sys_district` VALUES ('1742', '花垣县', '196');
INSERT INTO `sys_district` VALUES ('1743', '保靖县', '196');
INSERT INTO `sys_district` VALUES ('1744', '古丈县', '196');
INSERT INTO `sys_district` VALUES ('1745', '永顺县', '196');
INSERT INTO `sys_district` VALUES ('1746', '龙山县', '196');
INSERT INTO `sys_district` VALUES ('1747', '东山区', '197');
INSERT INTO `sys_district` VALUES ('1748', '荔湾区', '197');
INSERT INTO `sys_district` VALUES ('1749', '越秀区', '197');
INSERT INTO `sys_district` VALUES ('1750', '海珠区', '197');
INSERT INTO `sys_district` VALUES ('1751', '天河区', '197');
INSERT INTO `sys_district` VALUES ('1752', '芳村区', '197');
INSERT INTO `sys_district` VALUES ('1753', '白云区', '197');
INSERT INTO `sys_district` VALUES ('1754', '黄埔区', '197');
INSERT INTO `sys_district` VALUES ('1755', '番禺区', '197');
INSERT INTO `sys_district` VALUES ('1756', '花都区', '197');
INSERT INTO `sys_district` VALUES ('1757', '增城市', '197');
INSERT INTO `sys_district` VALUES ('1758', '从化市', '197');
INSERT INTO `sys_district` VALUES ('1759', '武江区', '198');
INSERT INTO `sys_district` VALUES ('1760', '浈江区', '198');
INSERT INTO `sys_district` VALUES ('1761', '曲江区', '198');
INSERT INTO `sys_district` VALUES ('1762', '始兴县', '198');
INSERT INTO `sys_district` VALUES ('1763', '仁化县', '198');
INSERT INTO `sys_district` VALUES ('1764', '翁源县', '198');
INSERT INTO `sys_district` VALUES ('1765', '乳源瑶族自治县', '198');
INSERT INTO `sys_district` VALUES ('1766', '新丰县', '198');
INSERT INTO `sys_district` VALUES ('1767', '乐昌市', '198');
INSERT INTO `sys_district` VALUES ('1768', '南雄市', '198');
INSERT INTO `sys_district` VALUES ('1769', '罗湖区', '199');
INSERT INTO `sys_district` VALUES ('1770', '福田区', '199');
INSERT INTO `sys_district` VALUES ('1771', '南山区', '199');
INSERT INTO `sys_district` VALUES ('1772', '宝安区', '199');
INSERT INTO `sys_district` VALUES ('1773', '龙岗区', '199');
INSERT INTO `sys_district` VALUES ('1774', '盐田区', '199');
INSERT INTO `sys_district` VALUES ('1775', '香洲区', '200');
INSERT INTO `sys_district` VALUES ('1776', '斗门区', '200');
INSERT INTO `sys_district` VALUES ('1777', '金湾区', '200');
INSERT INTO `sys_district` VALUES ('1778', '龙湖区', '201');
INSERT INTO `sys_district` VALUES ('1779', '金平区', '201');
INSERT INTO `sys_district` VALUES ('1780', '濠江区', '201');
INSERT INTO `sys_district` VALUES ('1781', '潮阳区', '201');
INSERT INTO `sys_district` VALUES ('1782', '潮南区', '201');
INSERT INTO `sys_district` VALUES ('1783', '澄海区', '201');
INSERT INTO `sys_district` VALUES ('1784', '南澳县', '201');
INSERT INTO `sys_district` VALUES ('1785', '禅城区', '202');
INSERT INTO `sys_district` VALUES ('1786', '南海区', '202');
INSERT INTO `sys_district` VALUES ('1787', '顺德区', '202');
INSERT INTO `sys_district` VALUES ('1788', '三水区', '202');
INSERT INTO `sys_district` VALUES ('1789', '高明区', '202');
INSERT INTO `sys_district` VALUES ('1790', '蓬江区', '203');
INSERT INTO `sys_district` VALUES ('1791', '江海区', '203');
INSERT INTO `sys_district` VALUES ('1792', '新会区', '203');
INSERT INTO `sys_district` VALUES ('1793', '台山市', '203');
INSERT INTO `sys_district` VALUES ('1794', '开平市', '203');
INSERT INTO `sys_district` VALUES ('1795', '鹤山市', '203');
INSERT INTO `sys_district` VALUES ('1796', '恩平市', '203');
INSERT INTO `sys_district` VALUES ('1797', '赤坎区', '204');
INSERT INTO `sys_district` VALUES ('1798', '霞山区', '204');
INSERT INTO `sys_district` VALUES ('1799', '坡头区', '204');
INSERT INTO `sys_district` VALUES ('1800', '麻章区', '204');
INSERT INTO `sys_district` VALUES ('1801', '遂溪县', '204');
INSERT INTO `sys_district` VALUES ('1802', '徐闻县', '204');
INSERT INTO `sys_district` VALUES ('1803', '廉江市', '204');
INSERT INTO `sys_district` VALUES ('1804', '雷州市', '204');
INSERT INTO `sys_district` VALUES ('1805', '吴川市', '204');
INSERT INTO `sys_district` VALUES ('1806', '茂南区', '205');
INSERT INTO `sys_district` VALUES ('1807', '茂港区', '205');
INSERT INTO `sys_district` VALUES ('1808', '电白县', '205');
INSERT INTO `sys_district` VALUES ('1809', '高州市', '205');
INSERT INTO `sys_district` VALUES ('1810', '化州市', '205');
INSERT INTO `sys_district` VALUES ('1811', '信宜市', '205');
INSERT INTO `sys_district` VALUES ('1812', '端州区', '206');
INSERT INTO `sys_district` VALUES ('1813', '鼎湖区', '206');
INSERT INTO `sys_district` VALUES ('1814', '广宁县', '206');
INSERT INTO `sys_district` VALUES ('1815', '怀集县', '206');
INSERT INTO `sys_district` VALUES ('1816', '封开县', '206');
INSERT INTO `sys_district` VALUES ('1817', '德庆县', '206');
INSERT INTO `sys_district` VALUES ('1818', '高要市', '206');
INSERT INTO `sys_district` VALUES ('1819', '四会市', '206');
INSERT INTO `sys_district` VALUES ('1820', '惠城区', '207');
INSERT INTO `sys_district` VALUES ('1821', '惠阳区', '207');
INSERT INTO `sys_district` VALUES ('1822', '博罗县', '207');
INSERT INTO `sys_district` VALUES ('1823', '惠东县', '207');
INSERT INTO `sys_district` VALUES ('1824', '龙门县', '207');
INSERT INTO `sys_district` VALUES ('1825', '梅江区', '208');
INSERT INTO `sys_district` VALUES ('1826', '梅县', '208');
INSERT INTO `sys_district` VALUES ('1827', '大埔县', '208');
INSERT INTO `sys_district` VALUES ('1828', '丰顺县', '208');
INSERT INTO `sys_district` VALUES ('1829', '五华县', '208');
INSERT INTO `sys_district` VALUES ('1830', '平远县', '208');
INSERT INTO `sys_district` VALUES ('1831', '蕉岭县', '208');
INSERT INTO `sys_district` VALUES ('1832', '兴宁市', '208');
INSERT INTO `sys_district` VALUES ('1833', '城区', '209');
INSERT INTO `sys_district` VALUES ('1834', '海丰县', '209');
INSERT INTO `sys_district` VALUES ('1835', '陆河县', '209');
INSERT INTO `sys_district` VALUES ('1836', '陆丰市', '209');
INSERT INTO `sys_district` VALUES ('1837', '源城区', '210');
INSERT INTO `sys_district` VALUES ('1838', '紫金县', '210');
INSERT INTO `sys_district` VALUES ('1839', '龙川县', '210');
INSERT INTO `sys_district` VALUES ('1840', '连平县', '210');
INSERT INTO `sys_district` VALUES ('1841', '和平县', '210');
INSERT INTO `sys_district` VALUES ('1842', '东源县', '210');
INSERT INTO `sys_district` VALUES ('1843', '江城区', '211');
INSERT INTO `sys_district` VALUES ('1844', '阳西县', '211');
INSERT INTO `sys_district` VALUES ('1845', '阳东县', '211');
INSERT INTO `sys_district` VALUES ('1846', '阳春市', '211');
INSERT INTO `sys_district` VALUES ('1847', '清城区', '212');
INSERT INTO `sys_district` VALUES ('1848', '佛冈县', '212');
INSERT INTO `sys_district` VALUES ('1849', '阳山县', '212');
INSERT INTO `sys_district` VALUES ('1850', '连山壮族瑶族自治县', '212');
INSERT INTO `sys_district` VALUES ('1851', '连南瑶族自治县', '212');
INSERT INTO `sys_district` VALUES ('1852', '清新县', '212');
INSERT INTO `sys_district` VALUES ('1853', '英德市', '212');
INSERT INTO `sys_district` VALUES ('1854', '连州市', '212');
INSERT INTO `sys_district` VALUES ('1855', '湘桥区', '215');
INSERT INTO `sys_district` VALUES ('1856', '潮安县', '215');
INSERT INTO `sys_district` VALUES ('1857', '饶平县', '215');
INSERT INTO `sys_district` VALUES ('1858', '榕城区', '216');
INSERT INTO `sys_district` VALUES ('1859', '揭东县', '216');
INSERT INTO `sys_district` VALUES ('1860', '揭西县', '216');
INSERT INTO `sys_district` VALUES ('1861', '惠来县', '216');
INSERT INTO `sys_district` VALUES ('1862', '普宁市', '216');
INSERT INTO `sys_district` VALUES ('1863', '云城区', '217');
INSERT INTO `sys_district` VALUES ('1864', '新兴县', '217');
INSERT INTO `sys_district` VALUES ('1865', '郁南县', '217');
INSERT INTO `sys_district` VALUES ('1866', '云安县', '217');
INSERT INTO `sys_district` VALUES ('1867', '罗定市', '217');
INSERT INTO `sys_district` VALUES ('1868', '兴宁区', '218');
INSERT INTO `sys_district` VALUES ('1869', '青秀区', '218');
INSERT INTO `sys_district` VALUES ('1870', '江南区', '218');
INSERT INTO `sys_district` VALUES ('1871', '西乡塘区', '218');
INSERT INTO `sys_district` VALUES ('1872', '良庆区', '218');
INSERT INTO `sys_district` VALUES ('1873', '邕宁区', '218');
INSERT INTO `sys_district` VALUES ('1874', '武鸣县', '218');
INSERT INTO `sys_district` VALUES ('1875', '隆安县', '218');
INSERT INTO `sys_district` VALUES ('1876', '马山县', '218');
INSERT INTO `sys_district` VALUES ('1877', '上林县', '218');
INSERT INTO `sys_district` VALUES ('1878', '宾阳县', '218');
INSERT INTO `sys_district` VALUES ('1879', '横县', '218');
INSERT INTO `sys_district` VALUES ('1880', '城中区', '219');
INSERT INTO `sys_district` VALUES ('1881', '鱼峰区', '219');
INSERT INTO `sys_district` VALUES ('1882', '柳南区', '219');
INSERT INTO `sys_district` VALUES ('1883', '柳北区', '219');
INSERT INTO `sys_district` VALUES ('1884', '柳江县', '219');
INSERT INTO `sys_district` VALUES ('1885', '柳城县', '219');
INSERT INTO `sys_district` VALUES ('1886', '鹿寨县', '219');
INSERT INTO `sys_district` VALUES ('1887', '融安县', '219');
INSERT INTO `sys_district` VALUES ('1888', '融水苗族自治县', '219');
INSERT INTO `sys_district` VALUES ('1889', '三江侗族自治县', '219');
INSERT INTO `sys_district` VALUES ('1890', '秀峰区', '220');
INSERT INTO `sys_district` VALUES ('1891', '叠彩区', '220');
INSERT INTO `sys_district` VALUES ('1892', '象山区', '220');
INSERT INTO `sys_district` VALUES ('1893', '七星区', '220');
INSERT INTO `sys_district` VALUES ('1894', '雁山区', '220');
INSERT INTO `sys_district` VALUES ('1895', '阳朔县', '220');
INSERT INTO `sys_district` VALUES ('1896', '临桂县', '220');
INSERT INTO `sys_district` VALUES ('1897', '灵川县', '220');
INSERT INTO `sys_district` VALUES ('1898', '全州县', '220');
INSERT INTO `sys_district` VALUES ('1899', '兴安县', '220');
INSERT INTO `sys_district` VALUES ('1900', '永福县', '220');
INSERT INTO `sys_district` VALUES ('1901', '灌阳县', '220');
INSERT INTO `sys_district` VALUES ('1902', '龙胜各族自治县', '220');
INSERT INTO `sys_district` VALUES ('1903', '资源县', '220');
INSERT INTO `sys_district` VALUES ('1904', '平乐县', '220');
INSERT INTO `sys_district` VALUES ('1905', '荔蒲县', '220');
INSERT INTO `sys_district` VALUES ('1906', '恭城瑶族自治县', '220');
INSERT INTO `sys_district` VALUES ('1907', '万秀区', '221');
INSERT INTO `sys_district` VALUES ('1908', '蝶山区', '221');
INSERT INTO `sys_district` VALUES ('1909', '长洲区', '221');
INSERT INTO `sys_district` VALUES ('1910', '苍梧县', '221');
INSERT INTO `sys_district` VALUES ('1911', '藤县', '221');
INSERT INTO `sys_district` VALUES ('1912', '蒙山县', '221');
INSERT INTO `sys_district` VALUES ('1913', '岑溪市', '221');
INSERT INTO `sys_district` VALUES ('1914', '海城区', '222');
INSERT INTO `sys_district` VALUES ('1915', '银海区', '222');
INSERT INTO `sys_district` VALUES ('1916', '铁山港区', '222');
INSERT INTO `sys_district` VALUES ('1917', '合浦县', '222');
INSERT INTO `sys_district` VALUES ('1918', '港口区', '223');
INSERT INTO `sys_district` VALUES ('1919', '防城区', '223');
INSERT INTO `sys_district` VALUES ('1920', '上思县', '223');
INSERT INTO `sys_district` VALUES ('1921', '东兴市', '223');
INSERT INTO `sys_district` VALUES ('1922', '钦南区', '224');
INSERT INTO `sys_district` VALUES ('1923', '钦北区', '224');
INSERT INTO `sys_district` VALUES ('1924', '灵山县', '224');
INSERT INTO `sys_district` VALUES ('1925', '浦北县', '224');
INSERT INTO `sys_district` VALUES ('1926', '港北区', '225');
INSERT INTO `sys_district` VALUES ('1927', '港南区', '225');
INSERT INTO `sys_district` VALUES ('1928', '覃塘区', '225');
INSERT INTO `sys_district` VALUES ('1929', '平南县', '225');
INSERT INTO `sys_district` VALUES ('1930', '桂平市', '225');
INSERT INTO `sys_district` VALUES ('1931', '玉州区', '226');
INSERT INTO `sys_district` VALUES ('1932', '容县', '226');
INSERT INTO `sys_district` VALUES ('1933', '陆川县', '226');
INSERT INTO `sys_district` VALUES ('1934', '博白县', '226');
INSERT INTO `sys_district` VALUES ('1935', '兴业县', '226');
INSERT INTO `sys_district` VALUES ('1936', '北流市', '226');
INSERT INTO `sys_district` VALUES ('1937', '右江区', '227');
INSERT INTO `sys_district` VALUES ('1938', '田阳县', '227');
INSERT INTO `sys_district` VALUES ('1939', '田东县', '227');
INSERT INTO `sys_district` VALUES ('1940', '平果县', '227');
INSERT INTO `sys_district` VALUES ('1941', '德保县', '227');
INSERT INTO `sys_district` VALUES ('1942', '靖西县', '227');
INSERT INTO `sys_district` VALUES ('1943', '那坡县', '227');
INSERT INTO `sys_district` VALUES ('1944', '凌云县', '227');
INSERT INTO `sys_district` VALUES ('1945', '乐业县', '227');
INSERT INTO `sys_district` VALUES ('1946', '田林县', '227');
INSERT INTO `sys_district` VALUES ('1947', '西林县', '227');
INSERT INTO `sys_district` VALUES ('1948', '隆林各族自治县', '227');
INSERT INTO `sys_district` VALUES ('1949', '八步区', '228');
INSERT INTO `sys_district` VALUES ('1950', '昭平县', '228');
INSERT INTO `sys_district` VALUES ('1951', '钟山县', '228');
INSERT INTO `sys_district` VALUES ('1952', '富川瑶族自治县', '228');
INSERT INTO `sys_district` VALUES ('1953', '金城江区', '229');
INSERT INTO `sys_district` VALUES ('1954', '南丹县', '229');
INSERT INTO `sys_district` VALUES ('1955', '天峨县', '229');
INSERT INTO `sys_district` VALUES ('1956', '凤山县', '229');
INSERT INTO `sys_district` VALUES ('1957', '东兰县', '229');
INSERT INTO `sys_district` VALUES ('1958', '罗城仫佬族自治县', '229');
INSERT INTO `sys_district` VALUES ('1959', '环江毛南族自治县', '229');
INSERT INTO `sys_district` VALUES ('1960', '巴马瑶族自治县', '229');
INSERT INTO `sys_district` VALUES ('1961', '都安瑶族自治县', '229');
INSERT INTO `sys_district` VALUES ('1962', '大化瑶族自治县', '229');
INSERT INTO `sys_district` VALUES ('1963', '宜州市', '229');
INSERT INTO `sys_district` VALUES ('1964', '兴宾区', '230');
INSERT INTO `sys_district` VALUES ('1965', '忻城县', '230');
INSERT INTO `sys_district` VALUES ('1966', '象州县', '230');
INSERT INTO `sys_district` VALUES ('1967', '武宣县', '230');
INSERT INTO `sys_district` VALUES ('1968', '金秀瑶族自治县', '230');
INSERT INTO `sys_district` VALUES ('1969', '合山市', '230');
INSERT INTO `sys_district` VALUES ('1970', '江洲区', '231');
INSERT INTO `sys_district` VALUES ('1971', '扶绥县', '231');
INSERT INTO `sys_district` VALUES ('1972', '宁明县', '231');
INSERT INTO `sys_district` VALUES ('1973', '龙州县', '231');
INSERT INTO `sys_district` VALUES ('1974', '大新县', '231');
INSERT INTO `sys_district` VALUES ('1975', '天等县', '231');
INSERT INTO `sys_district` VALUES ('1976', '凭祥市', '231');
INSERT INTO `sys_district` VALUES ('1977', '秀英区', '232');
INSERT INTO `sys_district` VALUES ('1978', '龙华区', '232');
INSERT INTO `sys_district` VALUES ('1979', '琼山区', '232');
INSERT INTO `sys_district` VALUES ('1980', '美兰区', '232');
INSERT INTO `sys_district` VALUES ('1981', '五指山市', '233');
INSERT INTO `sys_district` VALUES ('1982', '琼海市', '233');
INSERT INTO `sys_district` VALUES ('1983', '儋州市', '233');
INSERT INTO `sys_district` VALUES ('1984', '文昌市', '233');
INSERT INTO `sys_district` VALUES ('1985', '万宁市', '233');
INSERT INTO `sys_district` VALUES ('1986', '东方市', '233');
INSERT INTO `sys_district` VALUES ('1987', '定安县', '233');
INSERT INTO `sys_district` VALUES ('1988', '屯昌县', '233');
INSERT INTO `sys_district` VALUES ('1989', '澄迈县', '233');
INSERT INTO `sys_district` VALUES ('1990', '临高县', '233');
INSERT INTO `sys_district` VALUES ('1991', '白沙黎族自治县', '233');
INSERT INTO `sys_district` VALUES ('1992', '昌江黎族自治县', '233');
INSERT INTO `sys_district` VALUES ('1993', '乐东黎族自治县', '233');
INSERT INTO `sys_district` VALUES ('1994', '陵水黎族自治县', '233');
INSERT INTO `sys_district` VALUES ('1995', '保亭黎族苗族自治县', '233');
INSERT INTO `sys_district` VALUES ('1996', '琼中黎族苗族自治县', '233');
INSERT INTO `sys_district` VALUES ('1997', '西沙群岛', '233');
INSERT INTO `sys_district` VALUES ('1998', '南沙群岛', '233');
INSERT INTO `sys_district` VALUES ('1999', '中沙群岛的岛礁及其海域', '233');
INSERT INTO `sys_district` VALUES ('2000', '万州区', '234');
INSERT INTO `sys_district` VALUES ('2001', '涪陵区', '234');
INSERT INTO `sys_district` VALUES ('2002', '渝中区', '234');
INSERT INTO `sys_district` VALUES ('2003', '大渡口区', '234');
INSERT INTO `sys_district` VALUES ('2004', '江北区', '234');
INSERT INTO `sys_district` VALUES ('2005', '沙坪坝区', '234');
INSERT INTO `sys_district` VALUES ('2006', '九龙坡区', '234');
INSERT INTO `sys_district` VALUES ('2007', '南岸区', '234');
INSERT INTO `sys_district` VALUES ('2008', '北碚区', '234');
INSERT INTO `sys_district` VALUES ('2009', '万盛区', '234');
INSERT INTO `sys_district` VALUES ('2010', '双桥区', '234');
INSERT INTO `sys_district` VALUES ('2011', '渝北区', '234');
INSERT INTO `sys_district` VALUES ('2012', '巴南区', '234');
INSERT INTO `sys_district` VALUES ('2013', '黔江区', '234');
INSERT INTO `sys_district` VALUES ('2014', '长寿区', '234');
INSERT INTO `sys_district` VALUES ('2015', '綦江县', '234');
INSERT INTO `sys_district` VALUES ('2016', '潼南县', '234');
INSERT INTO `sys_district` VALUES ('2017', '铜梁县', '234');
INSERT INTO `sys_district` VALUES ('2018', '大足县', '234');
INSERT INTO `sys_district` VALUES ('2019', '荣昌县', '234');
INSERT INTO `sys_district` VALUES ('2020', '璧山县', '234');
INSERT INTO `sys_district` VALUES ('2021', '梁平县', '234');
INSERT INTO `sys_district` VALUES ('2022', '城口县', '234');
INSERT INTO `sys_district` VALUES ('2023', '丰都县', '234');
INSERT INTO `sys_district` VALUES ('2024', '垫江县', '234');
INSERT INTO `sys_district` VALUES ('2025', '武隆县', '234');
INSERT INTO `sys_district` VALUES ('2026', '忠县', '234');
INSERT INTO `sys_district` VALUES ('2027', '开县', '234');
INSERT INTO `sys_district` VALUES ('2028', '云阳县', '234');
INSERT INTO `sys_district` VALUES ('2029', '奉节县', '234');
INSERT INTO `sys_district` VALUES ('2030', '巫山县', '234');
INSERT INTO `sys_district` VALUES ('2031', '巫溪县', '234');
INSERT INTO `sys_district` VALUES ('2032', '石柱土家族自治县', '234');
INSERT INTO `sys_district` VALUES ('2033', '秀山土家族苗族自治县', '234');
INSERT INTO `sys_district` VALUES ('2034', '酉阳土家族苗族自治县', '234');
INSERT INTO `sys_district` VALUES ('2035', '彭水苗族土家族自治县', '234');
INSERT INTO `sys_district` VALUES ('2036', '江津市', '234');
INSERT INTO `sys_district` VALUES ('2037', '合川市', '234');
INSERT INTO `sys_district` VALUES ('2038', '永川市', '234');
INSERT INTO `sys_district` VALUES ('2039', '南川市', '234');
INSERT INTO `sys_district` VALUES ('2040', '锦江区', '235');
INSERT INTO `sys_district` VALUES ('2041', '青羊区', '235');
INSERT INTO `sys_district` VALUES ('2042', '金牛区', '235');
INSERT INTO `sys_district` VALUES ('2043', '武侯区', '235');
INSERT INTO `sys_district` VALUES ('2044', '成华区', '235');
INSERT INTO `sys_district` VALUES ('2045', '龙泉驿区', '235');
INSERT INTO `sys_district` VALUES ('2046', '青白江区', '235');
INSERT INTO `sys_district` VALUES ('2047', '新都区', '235');
INSERT INTO `sys_district` VALUES ('2048', '温江区', '235');
INSERT INTO `sys_district` VALUES ('2049', '金堂县', '235');
INSERT INTO `sys_district` VALUES ('2050', '双流县', '235');
INSERT INTO `sys_district` VALUES ('2051', '郫县', '235');
INSERT INTO `sys_district` VALUES ('2052', '大邑县', '235');
INSERT INTO `sys_district` VALUES ('2053', '蒲江县', '235');
INSERT INTO `sys_district` VALUES ('2054', '新津县', '235');
INSERT INTO `sys_district` VALUES ('2055', '都江堰市', '235');
INSERT INTO `sys_district` VALUES ('2056', '彭州市', '235');
INSERT INTO `sys_district` VALUES ('2057', '邛崃市', '235');
INSERT INTO `sys_district` VALUES ('2058', '崇州市', '235');
INSERT INTO `sys_district` VALUES ('2059', '自流井区', '236');
INSERT INTO `sys_district` VALUES ('2060', '贡井区', '236');
INSERT INTO `sys_district` VALUES ('2061', '大安区', '236');
INSERT INTO `sys_district` VALUES ('2062', '沿滩区', '236');
INSERT INTO `sys_district` VALUES ('2063', '荣县', '236');
INSERT INTO `sys_district` VALUES ('2064', '富顺县', '236');
INSERT INTO `sys_district` VALUES ('2065', '东区', '237');
INSERT INTO `sys_district` VALUES ('2066', '西区', '237');
INSERT INTO `sys_district` VALUES ('2067', '仁和区', '237');
INSERT INTO `sys_district` VALUES ('2068', '米易县', '237');
INSERT INTO `sys_district` VALUES ('2069', '盐边县', '237');
INSERT INTO `sys_district` VALUES ('2070', '江阳区', '238');
INSERT INTO `sys_district` VALUES ('2071', '纳溪区', '238');
INSERT INTO `sys_district` VALUES ('2072', '龙马潭区', '238');
INSERT INTO `sys_district` VALUES ('2073', '泸县', '238');
INSERT INTO `sys_district` VALUES ('2074', '合江县', '238');
INSERT INTO `sys_district` VALUES ('2075', '叙永县', '238');
INSERT INTO `sys_district` VALUES ('2076', '古蔺县', '238');
INSERT INTO `sys_district` VALUES ('2077', '旌阳区', '239');
INSERT INTO `sys_district` VALUES ('2078', '中江县', '239');
INSERT INTO `sys_district` VALUES ('2079', '罗江县', '239');
INSERT INTO `sys_district` VALUES ('2080', '广汉市', '239');
INSERT INTO `sys_district` VALUES ('2081', '什邡市', '239');
INSERT INTO `sys_district` VALUES ('2082', '绵竹市', '239');
INSERT INTO `sys_district` VALUES ('2083', '涪城区', '240');
INSERT INTO `sys_district` VALUES ('2084', '游仙区', '240');
INSERT INTO `sys_district` VALUES ('2085', '三台县', '240');
INSERT INTO `sys_district` VALUES ('2086', '盐亭县', '240');
INSERT INTO `sys_district` VALUES ('2087', '安县', '240');
INSERT INTO `sys_district` VALUES ('2088', '梓潼县', '240');
INSERT INTO `sys_district` VALUES ('2089', '北川羌族自治县', '240');
INSERT INTO `sys_district` VALUES ('2090', '平武县', '240');
INSERT INTO `sys_district` VALUES ('2091', '江油市', '240');
INSERT INTO `sys_district` VALUES ('2092', '市中区', '241');
INSERT INTO `sys_district` VALUES ('2093', '元坝区', '241');
INSERT INTO `sys_district` VALUES ('2094', '朝天区', '241');
INSERT INTO `sys_district` VALUES ('2095', '旺苍县', '241');
INSERT INTO `sys_district` VALUES ('2096', '青川县', '241');
INSERT INTO `sys_district` VALUES ('2097', '剑阁县', '241');
INSERT INTO `sys_district` VALUES ('2098', '苍溪县', '241');
INSERT INTO `sys_district` VALUES ('2099', '船山区', '242');
INSERT INTO `sys_district` VALUES ('2100', '安居区', '242');
INSERT INTO `sys_district` VALUES ('2101', '蓬溪县', '242');
INSERT INTO `sys_district` VALUES ('2102', '射洪县', '242');
INSERT INTO `sys_district` VALUES ('2103', '大英县', '242');
INSERT INTO `sys_district` VALUES ('2104', '市中区', '243');
INSERT INTO `sys_district` VALUES ('2105', '东兴区', '243');
INSERT INTO `sys_district` VALUES ('2106', '威远县', '243');
INSERT INTO `sys_district` VALUES ('2107', '资中县', '243');
INSERT INTO `sys_district` VALUES ('2108', '隆昌县', '243');
INSERT INTO `sys_district` VALUES ('2109', '市中区', '244');
INSERT INTO `sys_district` VALUES ('2110', '沙湾区', '244');
INSERT INTO `sys_district` VALUES ('2111', '五通桥区', '244');
INSERT INTO `sys_district` VALUES ('2112', '金口河区', '244');
INSERT INTO `sys_district` VALUES ('2113', '犍为县', '244');
INSERT INTO `sys_district` VALUES ('2114', '井研县', '244');
INSERT INTO `sys_district` VALUES ('2115', '夹江县', '244');
INSERT INTO `sys_district` VALUES ('2116', '沐川县', '244');
INSERT INTO `sys_district` VALUES ('2117', '峨边彝族自治县', '244');
INSERT INTO `sys_district` VALUES ('2118', '马边彝族自治县', '244');
INSERT INTO `sys_district` VALUES ('2119', '峨眉山市', '244');
INSERT INTO `sys_district` VALUES ('2120', '顺庆区', '245');
INSERT INTO `sys_district` VALUES ('2121', '高坪区', '245');
INSERT INTO `sys_district` VALUES ('2122', '嘉陵区', '245');
INSERT INTO `sys_district` VALUES ('2123', '南部县', '245');
INSERT INTO `sys_district` VALUES ('2124', '营山县', '245');
INSERT INTO `sys_district` VALUES ('2125', '蓬安县', '245');
INSERT INTO `sys_district` VALUES ('2126', '仪陇县', '245');
INSERT INTO `sys_district` VALUES ('2127', '西充县', '245');
INSERT INTO `sys_district` VALUES ('2128', '阆中市', '245');
INSERT INTO `sys_district` VALUES ('2129', '东坡区', '246');
INSERT INTO `sys_district` VALUES ('2130', '仁寿县', '246');
INSERT INTO `sys_district` VALUES ('2131', '彭山县', '246');
INSERT INTO `sys_district` VALUES ('2132', '洪雅县', '246');
INSERT INTO `sys_district` VALUES ('2133', '丹棱县', '246');
INSERT INTO `sys_district` VALUES ('2134', '青神县', '246');
INSERT INTO `sys_district` VALUES ('2135', '翠屏区', '247');
INSERT INTO `sys_district` VALUES ('2136', '宜宾县', '247');
INSERT INTO `sys_district` VALUES ('2137', '南溪县', '247');
INSERT INTO `sys_district` VALUES ('2138', '江安县', '247');
INSERT INTO `sys_district` VALUES ('2139', '长宁县', '247');
INSERT INTO `sys_district` VALUES ('2140', '高县', '247');
INSERT INTO `sys_district` VALUES ('2141', '珙县', '247');
INSERT INTO `sys_district` VALUES ('2142', '筠连县', '247');
INSERT INTO `sys_district` VALUES ('2143', '兴文县', '247');
INSERT INTO `sys_district` VALUES ('2144', '屏山县', '247');
INSERT INTO `sys_district` VALUES ('2145', '广安区', '248');
INSERT INTO `sys_district` VALUES ('2146', '岳池县', '248');
INSERT INTO `sys_district` VALUES ('2147', '武胜县', '248');
INSERT INTO `sys_district` VALUES ('2148', '邻水县', '248');
INSERT INTO `sys_district` VALUES ('2149', '华蓥市', '248');
INSERT INTO `sys_district` VALUES ('2150', '通川区', '249');
INSERT INTO `sys_district` VALUES ('2151', '达县', '249');
INSERT INTO `sys_district` VALUES ('2152', '宣汉县', '249');
INSERT INTO `sys_district` VALUES ('2153', '开江县', '249');
INSERT INTO `sys_district` VALUES ('2154', '大竹县', '249');
INSERT INTO `sys_district` VALUES ('2155', '渠县', '249');
INSERT INTO `sys_district` VALUES ('2156', '万源市', '249');
INSERT INTO `sys_district` VALUES ('2157', '雨城区', '250');
INSERT INTO `sys_district` VALUES ('2158', '名山县', '250');
INSERT INTO `sys_district` VALUES ('2159', '荥经县', '250');
INSERT INTO `sys_district` VALUES ('2160', '汉源县', '250');
INSERT INTO `sys_district` VALUES ('2161', '石棉县', '250');
INSERT INTO `sys_district` VALUES ('2162', '天全县', '250');
INSERT INTO `sys_district` VALUES ('2163', '芦山县', '250');
INSERT INTO `sys_district` VALUES ('2164', '宝兴县', '250');
INSERT INTO `sys_district` VALUES ('2165', '巴州区', '251');
INSERT INTO `sys_district` VALUES ('2166', '通江县', '251');
INSERT INTO `sys_district` VALUES ('2167', '南江县', '251');
INSERT INTO `sys_district` VALUES ('2168', '平昌县', '251');
INSERT INTO `sys_district` VALUES ('2169', '雁江区', '252');
INSERT INTO `sys_district` VALUES ('2170', '安岳县', '252');
INSERT INTO `sys_district` VALUES ('2171', '乐至县', '252');
INSERT INTO `sys_district` VALUES ('2172', '简阳市', '252');
INSERT INTO `sys_district` VALUES ('2173', '汶川县', '253');
INSERT INTO `sys_district` VALUES ('2174', '理县', '253');
INSERT INTO `sys_district` VALUES ('2175', '茂县', '253');
INSERT INTO `sys_district` VALUES ('2176', '松潘县', '253');
INSERT INTO `sys_district` VALUES ('2177', '九寨沟县', '253');
INSERT INTO `sys_district` VALUES ('2178', '金川县', '253');
INSERT INTO `sys_district` VALUES ('2179', '小金县', '253');
INSERT INTO `sys_district` VALUES ('2180', '黑水县', '253');
INSERT INTO `sys_district` VALUES ('2181', '马尔康县', '253');
INSERT INTO `sys_district` VALUES ('2182', '壤塘县', '253');
INSERT INTO `sys_district` VALUES ('2183', '阿坝县', '253');
INSERT INTO `sys_district` VALUES ('2184', '若尔盖县', '253');
INSERT INTO `sys_district` VALUES ('2185', '红原县', '253');
INSERT INTO `sys_district` VALUES ('2186', '康定县', '254');
INSERT INTO `sys_district` VALUES ('2187', '泸定县', '254');
INSERT INTO `sys_district` VALUES ('2188', '丹巴县', '254');
INSERT INTO `sys_district` VALUES ('2189', '九龙县', '254');
INSERT INTO `sys_district` VALUES ('2190', '雅江县', '254');
INSERT INTO `sys_district` VALUES ('2191', '道孚县', '254');
INSERT INTO `sys_district` VALUES ('2192', '炉霍县', '254');
INSERT INTO `sys_district` VALUES ('2193', '甘孜县', '254');
INSERT INTO `sys_district` VALUES ('2194', '新龙县', '254');
INSERT INTO `sys_district` VALUES ('2195', '德格县', '254');
INSERT INTO `sys_district` VALUES ('2196', '白玉县', '254');
INSERT INTO `sys_district` VALUES ('2197', '石渠县', '254');
INSERT INTO `sys_district` VALUES ('2198', '色达县', '254');
INSERT INTO `sys_district` VALUES ('2199', '理塘县', '254');
INSERT INTO `sys_district` VALUES ('2200', '巴塘县', '254');
INSERT INTO `sys_district` VALUES ('2201', '乡城县', '254');
INSERT INTO `sys_district` VALUES ('2202', '稻城县', '254');
INSERT INTO `sys_district` VALUES ('2203', '得荣县', '254');
INSERT INTO `sys_district` VALUES ('2204', '西昌市', '255');
INSERT INTO `sys_district` VALUES ('2205', '木里藏族自治县', '255');
INSERT INTO `sys_district` VALUES ('2206', '盐源县', '255');
INSERT INTO `sys_district` VALUES ('2207', '德昌县', '255');
INSERT INTO `sys_district` VALUES ('2208', '会理县', '255');
INSERT INTO `sys_district` VALUES ('2209', '会东县', '255');
INSERT INTO `sys_district` VALUES ('2210', '宁南县', '255');
INSERT INTO `sys_district` VALUES ('2211', '普格县', '255');
INSERT INTO `sys_district` VALUES ('2212', '布拖县', '255');
INSERT INTO `sys_district` VALUES ('2213', '金阳县', '255');
INSERT INTO `sys_district` VALUES ('2214', '昭觉县', '255');
INSERT INTO `sys_district` VALUES ('2215', '喜德县', '255');
INSERT INTO `sys_district` VALUES ('2216', '冕宁县', '255');
INSERT INTO `sys_district` VALUES ('2217', '越西县', '255');
INSERT INTO `sys_district` VALUES ('2218', '甘洛县', '255');
INSERT INTO `sys_district` VALUES ('2219', '美姑县', '255');
INSERT INTO `sys_district` VALUES ('2220', '雷波县', '255');
INSERT INTO `sys_district` VALUES ('2221', '南明区', '256');
INSERT INTO `sys_district` VALUES ('2222', '云岩区', '256');
INSERT INTO `sys_district` VALUES ('2223', '花溪区', '256');
INSERT INTO `sys_district` VALUES ('2224', '乌当区', '256');
INSERT INTO `sys_district` VALUES ('2225', '白云区', '256');
INSERT INTO `sys_district` VALUES ('2226', '小河区', '256');
INSERT INTO `sys_district` VALUES ('2227', '开阳县', '256');
INSERT INTO `sys_district` VALUES ('2228', '息烽县', '256');
INSERT INTO `sys_district` VALUES ('2229', '修文县', '256');
INSERT INTO `sys_district` VALUES ('2230', '清镇市', '256');
INSERT INTO `sys_district` VALUES ('2231', '钟山区', '257');
INSERT INTO `sys_district` VALUES ('2232', '六枝特区', '257');
INSERT INTO `sys_district` VALUES ('2233', '水城县', '257');
INSERT INTO `sys_district` VALUES ('2234', '盘县', '257');
INSERT INTO `sys_district` VALUES ('2235', '红花岗区', '258');
INSERT INTO `sys_district` VALUES ('2236', '汇川区', '258');
INSERT INTO `sys_district` VALUES ('2237', '遵义县', '258');
INSERT INTO `sys_district` VALUES ('2238', '桐梓县', '258');
INSERT INTO `sys_district` VALUES ('2239', '绥阳县', '258');
INSERT INTO `sys_district` VALUES ('2240', '正安县', '258');
INSERT INTO `sys_district` VALUES ('2241', '道真仡佬族苗族自治县', '258');
INSERT INTO `sys_district` VALUES ('2242', '务川仡佬族苗族自治县', '258');
INSERT INTO `sys_district` VALUES ('2243', '凤冈县', '258');
INSERT INTO `sys_district` VALUES ('2244', '湄潭县', '258');
INSERT INTO `sys_district` VALUES ('2245', '余庆县', '258');
INSERT INTO `sys_district` VALUES ('2246', '习水县', '258');
INSERT INTO `sys_district` VALUES ('2247', '赤水市', '258');
INSERT INTO `sys_district` VALUES ('2248', '仁怀市', '258');
INSERT INTO `sys_district` VALUES ('2249', '西秀区', '259');
INSERT INTO `sys_district` VALUES ('2250', '平坝县', '259');
INSERT INTO `sys_district` VALUES ('2251', '普定县', '259');
INSERT INTO `sys_district` VALUES ('2252', '镇宁布依族苗族自治县', '259');
INSERT INTO `sys_district` VALUES ('2253', '关岭布依族苗族自治县', '259');
INSERT INTO `sys_district` VALUES ('2254', '紫云苗族布依族自治县', '259');
INSERT INTO `sys_district` VALUES ('2255', '铜仁市', '260');
INSERT INTO `sys_district` VALUES ('2256', '江口县', '260');
INSERT INTO `sys_district` VALUES ('2257', '玉屏侗族自治县', '260');
INSERT INTO `sys_district` VALUES ('2258', '石阡县', '260');
INSERT INTO `sys_district` VALUES ('2259', '思南县', '260');
INSERT INTO `sys_district` VALUES ('2260', '印江土家族苗族自治县', '260');
INSERT INTO `sys_district` VALUES ('2261', '德江县', '260');
INSERT INTO `sys_district` VALUES ('2262', '沿河土家族自治县', '260');
INSERT INTO `sys_district` VALUES ('2263', '松桃苗族自治县', '260');
INSERT INTO `sys_district` VALUES ('2264', '万山特区', '260');
INSERT INTO `sys_district` VALUES ('2265', '兴义市', '261');
INSERT INTO `sys_district` VALUES ('2266', '兴仁县', '261');
INSERT INTO `sys_district` VALUES ('2267', '普安县', '261');
INSERT INTO `sys_district` VALUES ('2268', '晴隆县', '261');
INSERT INTO `sys_district` VALUES ('2269', '贞丰县', '261');
INSERT INTO `sys_district` VALUES ('2270', '望谟县', '261');
INSERT INTO `sys_district` VALUES ('2271', '册亨县', '261');
INSERT INTO `sys_district` VALUES ('2272', '安龙县', '261');
INSERT INTO `sys_district` VALUES ('2273', '毕节市', '262');
INSERT INTO `sys_district` VALUES ('2274', '大方县', '262');
INSERT INTO `sys_district` VALUES ('2275', '黔西县', '262');
INSERT INTO `sys_district` VALUES ('2276', '金沙县', '262');
INSERT INTO `sys_district` VALUES ('2277', '织金县', '262');
INSERT INTO `sys_district` VALUES ('2278', '纳雍县', '262');
INSERT INTO `sys_district` VALUES ('2279', '威宁彝族回族苗族自治县', '262');
INSERT INTO `sys_district` VALUES ('2280', '赫章县', '262');
INSERT INTO `sys_district` VALUES ('2281', '凯里市', '263');
INSERT INTO `sys_district` VALUES ('2282', '黄平县', '263');
INSERT INTO `sys_district` VALUES ('2283', '施秉县', '263');
INSERT INTO `sys_district` VALUES ('2284', '三穗县', '263');
INSERT INTO `sys_district` VALUES ('2285', '镇远县', '263');
INSERT INTO `sys_district` VALUES ('2286', '岑巩县', '263');
INSERT INTO `sys_district` VALUES ('2287', '天柱县', '263');
INSERT INTO `sys_district` VALUES ('2288', '锦屏县', '263');
INSERT INTO `sys_district` VALUES ('2289', '剑河县', '263');
INSERT INTO `sys_district` VALUES ('2290', '台江县', '263');
INSERT INTO `sys_district` VALUES ('2291', '黎平县', '263');
INSERT INTO `sys_district` VALUES ('2292', '榕江县', '263');
INSERT INTO `sys_district` VALUES ('2293', '从江县', '263');
INSERT INTO `sys_district` VALUES ('2294', '雷山县', '263');
INSERT INTO `sys_district` VALUES ('2295', '麻江县', '263');
INSERT INTO `sys_district` VALUES ('2296', '丹寨县', '263');
INSERT INTO `sys_district` VALUES ('2297', '都匀市', '264');
INSERT INTO `sys_district` VALUES ('2298', '福泉市', '264');
INSERT INTO `sys_district` VALUES ('2299', '荔波县', '264');
INSERT INTO `sys_district` VALUES ('2300', '贵定县', '264');
INSERT INTO `sys_district` VALUES ('2301', '瓮安县', '264');
INSERT INTO `sys_district` VALUES ('2302', '独山县', '264');
INSERT INTO `sys_district` VALUES ('2303', '平塘县', '264');
INSERT INTO `sys_district` VALUES ('2304', '罗甸县', '264');
INSERT INTO `sys_district` VALUES ('2305', '长顺县', '264');
INSERT INTO `sys_district` VALUES ('2306', '龙里县', '264');
INSERT INTO `sys_district` VALUES ('2307', '惠水县', '264');
INSERT INTO `sys_district` VALUES ('2308', '三都水族自治县', '264');
INSERT INTO `sys_district` VALUES ('2309', '五华区', '265');
INSERT INTO `sys_district` VALUES ('2310', '盘龙区', '265');
INSERT INTO `sys_district` VALUES ('2311', '官渡区', '265');
INSERT INTO `sys_district` VALUES ('2312', '西山区', '265');
INSERT INTO `sys_district` VALUES ('2313', '东川区', '265');
INSERT INTO `sys_district` VALUES ('2314', '呈贡县', '265');
INSERT INTO `sys_district` VALUES ('2315', '晋宁县', '265');
INSERT INTO `sys_district` VALUES ('2316', '富民县', '265');
INSERT INTO `sys_district` VALUES ('2317', '宜良县', '265');
INSERT INTO `sys_district` VALUES ('2318', '石林彝族自治县', '265');
INSERT INTO `sys_district` VALUES ('2319', '嵩明县', '265');
INSERT INTO `sys_district` VALUES ('2320', '禄劝彝族苗族自治县', '265');
INSERT INTO `sys_district` VALUES ('2321', '寻甸回族彝族自治县', '265');
INSERT INTO `sys_district` VALUES ('2322', '安宁市', '265');
INSERT INTO `sys_district` VALUES ('2323', '麒麟区', '266');
INSERT INTO `sys_district` VALUES ('2324', '马龙县', '266');
INSERT INTO `sys_district` VALUES ('2325', '陆良县', '266');
INSERT INTO `sys_district` VALUES ('2326', '师宗县', '266');
INSERT INTO `sys_district` VALUES ('2327', '罗平县', '266');
INSERT INTO `sys_district` VALUES ('2328', '富源县', '266');
INSERT INTO `sys_district` VALUES ('2329', '会泽县', '266');
INSERT INTO `sys_district` VALUES ('2330', '沾益县', '266');
INSERT INTO `sys_district` VALUES ('2331', '宣威市', '266');
INSERT INTO `sys_district` VALUES ('2332', '红塔区', '267');
INSERT INTO `sys_district` VALUES ('2333', '江川县', '267');
INSERT INTO `sys_district` VALUES ('2334', '澄江县', '267');
INSERT INTO `sys_district` VALUES ('2335', '通海县', '267');
INSERT INTO `sys_district` VALUES ('2336', '华宁县', '267');
INSERT INTO `sys_district` VALUES ('2337', '易门县', '267');
INSERT INTO `sys_district` VALUES ('2338', '峨山彝族自治县', '267');
INSERT INTO `sys_district` VALUES ('2339', '新平彝族傣族自治县', '267');
INSERT INTO `sys_district` VALUES ('2340', '元江哈尼族彝族傣族自治县', '267');
INSERT INTO `sys_district` VALUES ('2341', '隆阳区', '268');
INSERT INTO `sys_district` VALUES ('2342', '施甸县', '268');
INSERT INTO `sys_district` VALUES ('2343', '腾冲县', '268');
INSERT INTO `sys_district` VALUES ('2344', '龙陵县', '268');
INSERT INTO `sys_district` VALUES ('2345', '昌宁县', '268');
INSERT INTO `sys_district` VALUES ('2346', '昭阳区', '269');
INSERT INTO `sys_district` VALUES ('2347', '鲁甸县', '269');
INSERT INTO `sys_district` VALUES ('2348', '巧家县', '269');
INSERT INTO `sys_district` VALUES ('2349', '盐津县', '269');
INSERT INTO `sys_district` VALUES ('2350', '大关县', '269');
INSERT INTO `sys_district` VALUES ('2351', '永善县', '269');
INSERT INTO `sys_district` VALUES ('2352', '绥江县', '269');
INSERT INTO `sys_district` VALUES ('2353', '镇雄县', '269');
INSERT INTO `sys_district` VALUES ('2354', '彝良县', '269');
INSERT INTO `sys_district` VALUES ('2355', '威信县', '269');
INSERT INTO `sys_district` VALUES ('2356', '水富县', '269');
INSERT INTO `sys_district` VALUES ('2357', '古城区', '270');
INSERT INTO `sys_district` VALUES ('2358', '玉龙纳西族自治县', '270');
INSERT INTO `sys_district` VALUES ('2359', '永胜县', '270');
INSERT INTO `sys_district` VALUES ('2360', '华坪县', '270');
INSERT INTO `sys_district` VALUES ('2361', '宁蒗彝族自治县', '270');
INSERT INTO `sys_district` VALUES ('2362', '翠云区', '271');
INSERT INTO `sys_district` VALUES ('2363', '普洱哈尼族彝族自治县', '271');
INSERT INTO `sys_district` VALUES ('2364', '墨江哈尼族自治县', '271');
INSERT INTO `sys_district` VALUES ('2365', '景东彝族自治县', '271');
INSERT INTO `sys_district` VALUES ('2366', '景谷傣族彝族自治县', '271');
INSERT INTO `sys_district` VALUES ('2367', '镇沅彝族哈尼族拉祜族自治县', '271');
INSERT INTO `sys_district` VALUES ('2368', '江城哈尼族彝族自治县', '271');
INSERT INTO `sys_district` VALUES ('2369', '孟连傣族拉祜族佤族自治县', '271');
INSERT INTO `sys_district` VALUES ('2370', '澜沧拉祜族自治县', '271');
INSERT INTO `sys_district` VALUES ('2371', '西盟佤族自治县', '271');
INSERT INTO `sys_district` VALUES ('2372', '临翔区', '272');
INSERT INTO `sys_district` VALUES ('2373', '凤庆县', '272');
INSERT INTO `sys_district` VALUES ('2374', '云县', '272');
INSERT INTO `sys_district` VALUES ('2375', '永德县', '272');
INSERT INTO `sys_district` VALUES ('2376', '镇康县', '272');
INSERT INTO `sys_district` VALUES ('2377', '双江拉祜族佤族布朗族傣族自治县', '272');
INSERT INTO `sys_district` VALUES ('2378', '耿马傣族佤族自治县', '272');
INSERT INTO `sys_district` VALUES ('2379', '沧源佤族自治县', '272');
INSERT INTO `sys_district` VALUES ('2380', '楚雄市', '273');
INSERT INTO `sys_district` VALUES ('2381', '双柏县', '273');
INSERT INTO `sys_district` VALUES ('2382', '牟定县', '273');
INSERT INTO `sys_district` VALUES ('2383', '南华县', '273');
INSERT INTO `sys_district` VALUES ('2384', '姚安县', '273');
INSERT INTO `sys_district` VALUES ('2385', '大姚县', '273');
INSERT INTO `sys_district` VALUES ('2386', '永仁县', '273');
INSERT INTO `sys_district` VALUES ('2387', '元谋县', '273');
INSERT INTO `sys_district` VALUES ('2388', '武定县', '273');
INSERT INTO `sys_district` VALUES ('2389', '禄丰县', '273');
INSERT INTO `sys_district` VALUES ('2390', '个旧市', '274');
INSERT INTO `sys_district` VALUES ('2391', '开远市', '274');
INSERT INTO `sys_district` VALUES ('2392', '蒙自县', '274');
INSERT INTO `sys_district` VALUES ('2393', '屏边苗族自治县', '274');
INSERT INTO `sys_district` VALUES ('2394', '建水县', '274');
INSERT INTO `sys_district` VALUES ('2395', '石屏县', '274');
INSERT INTO `sys_district` VALUES ('2396', '弥勒县', '274');
INSERT INTO `sys_district` VALUES ('2397', '泸西县', '274');
INSERT INTO `sys_district` VALUES ('2398', '元阳县', '274');
INSERT INTO `sys_district` VALUES ('2399', '红河县', '274');
INSERT INTO `sys_district` VALUES ('2400', '金平苗族瑶族傣族自治县', '274');
INSERT INTO `sys_district` VALUES ('2401', '绿春县', '274');
INSERT INTO `sys_district` VALUES ('2402', '河口瑶族自治县', '274');
INSERT INTO `sys_district` VALUES ('2403', '文山县', '275');
INSERT INTO `sys_district` VALUES ('2404', '砚山县', '275');
INSERT INTO `sys_district` VALUES ('2405', '西畴县', '275');
INSERT INTO `sys_district` VALUES ('2406', '麻栗坡县', '275');
INSERT INTO `sys_district` VALUES ('2407', '马关县', '275');
INSERT INTO `sys_district` VALUES ('2408', '丘北县', '275');
INSERT INTO `sys_district` VALUES ('2409', '广南县', '275');
INSERT INTO `sys_district` VALUES ('2410', '富宁县', '275');
INSERT INTO `sys_district` VALUES ('2411', '景洪市', '276');
INSERT INTO `sys_district` VALUES ('2412', '勐海县', '276');
INSERT INTO `sys_district` VALUES ('2413', '勐腊县', '276');
INSERT INTO `sys_district` VALUES ('2414', '大理市', '277');
INSERT INTO `sys_district` VALUES ('2415', '漾濞彝族自治县', '277');
INSERT INTO `sys_district` VALUES ('2416', '祥云县', '277');
INSERT INTO `sys_district` VALUES ('2417', '宾川县', '277');
INSERT INTO `sys_district` VALUES ('2418', '弥渡县', '277');
INSERT INTO `sys_district` VALUES ('2419', '南涧彝族自治县', '277');
INSERT INTO `sys_district` VALUES ('2420', '巍山彝族回族自治县', '277');
INSERT INTO `sys_district` VALUES ('2421', '永平县', '277');
INSERT INTO `sys_district` VALUES ('2422', '云龙县', '277');
INSERT INTO `sys_district` VALUES ('2423', '洱源县', '277');
INSERT INTO `sys_district` VALUES ('2424', '剑川县', '277');
INSERT INTO `sys_district` VALUES ('2425', '鹤庆县', '277');
INSERT INTO `sys_district` VALUES ('2426', '瑞丽市', '278');
INSERT INTO `sys_district` VALUES ('2427', '潞西市', '278');
INSERT INTO `sys_district` VALUES ('2428', '梁河县', '278');
INSERT INTO `sys_district` VALUES ('2429', '盈江县', '278');
INSERT INTO `sys_district` VALUES ('2430', '陇川县', '278');
INSERT INTO `sys_district` VALUES ('2431', '泸水县', '279');
INSERT INTO `sys_district` VALUES ('2432', '福贡县', '279');
INSERT INTO `sys_district` VALUES ('2433', '贡山独龙族怒族自治县', '279');
INSERT INTO `sys_district` VALUES ('2434', '兰坪白族普米族自治县', '279');
INSERT INTO `sys_district` VALUES ('2435', '香格里拉县', '280');
INSERT INTO `sys_district` VALUES ('2436', '德钦县', '280');
INSERT INTO `sys_district` VALUES ('2437', '维西傈僳族自治县', '280');
INSERT INTO `sys_district` VALUES ('2438', '城关区', '281');
INSERT INTO `sys_district` VALUES ('2439', '林周县', '281');
INSERT INTO `sys_district` VALUES ('2440', '当雄县', '281');
INSERT INTO `sys_district` VALUES ('2441', '尼木县', '281');
INSERT INTO `sys_district` VALUES ('2442', '曲水县', '281');
INSERT INTO `sys_district` VALUES ('2443', '堆龙德庆县', '281');
INSERT INTO `sys_district` VALUES ('2444', '达孜县', '281');
INSERT INTO `sys_district` VALUES ('2445', '墨竹工卡县', '281');
INSERT INTO `sys_district` VALUES ('2446', '昌都县', '282');
INSERT INTO `sys_district` VALUES ('2447', '江达县', '282');
INSERT INTO `sys_district` VALUES ('2448', '贡觉县', '282');
INSERT INTO `sys_district` VALUES ('2449', '类乌齐县', '282');
INSERT INTO `sys_district` VALUES ('2450', '丁青县', '282');
INSERT INTO `sys_district` VALUES ('2451', '察雅县', '282');
INSERT INTO `sys_district` VALUES ('2452', '八宿县', '282');
INSERT INTO `sys_district` VALUES ('2453', '左贡县', '282');
INSERT INTO `sys_district` VALUES ('2454', '芒康县', '282');
INSERT INTO `sys_district` VALUES ('2455', '洛隆县', '282');
INSERT INTO `sys_district` VALUES ('2456', '边坝县', '282');
INSERT INTO `sys_district` VALUES ('2457', '乃东县', '283');
INSERT INTO `sys_district` VALUES ('2458', '扎囊县', '283');
INSERT INTO `sys_district` VALUES ('2459', '贡嘎县', '283');
INSERT INTO `sys_district` VALUES ('2460', '桑日县', '283');
INSERT INTO `sys_district` VALUES ('2461', '琼结县', '283');
INSERT INTO `sys_district` VALUES ('2462', '曲松县', '283');
INSERT INTO `sys_district` VALUES ('2463', '措美县', '283');
INSERT INTO `sys_district` VALUES ('2464', '洛扎县', '283');
INSERT INTO `sys_district` VALUES ('2465', '加查县', '283');
INSERT INTO `sys_district` VALUES ('2466', '隆子县', '283');
INSERT INTO `sys_district` VALUES ('2467', '错那县', '283');
INSERT INTO `sys_district` VALUES ('2468', '浪卡子县', '283');
INSERT INTO `sys_district` VALUES ('2469', '日喀则市', '284');
INSERT INTO `sys_district` VALUES ('2470', '南木林县', '284');
INSERT INTO `sys_district` VALUES ('2471', '江孜县', '284');
INSERT INTO `sys_district` VALUES ('2472', '定日县', '284');
INSERT INTO `sys_district` VALUES ('2473', '萨迦县', '284');
INSERT INTO `sys_district` VALUES ('2474', '拉孜县', '284');
INSERT INTO `sys_district` VALUES ('2475', '昂仁县', '284');
INSERT INTO `sys_district` VALUES ('2476', '谢通门县', '284');
INSERT INTO `sys_district` VALUES ('2477', '白朗县', '284');
INSERT INTO `sys_district` VALUES ('2478', '仁布县', '284');
INSERT INTO `sys_district` VALUES ('2479', '康马县', '284');
INSERT INTO `sys_district` VALUES ('2480', '定结县', '284');
INSERT INTO `sys_district` VALUES ('2481', '仲巴县', '284');
INSERT INTO `sys_district` VALUES ('2482', '亚东县', '284');
INSERT INTO `sys_district` VALUES ('2483', '吉隆县', '284');
INSERT INTO `sys_district` VALUES ('2484', '聂拉木县', '284');
INSERT INTO `sys_district` VALUES ('2485', '萨嘎县', '284');
INSERT INTO `sys_district` VALUES ('2486', '岗巴县', '284');
INSERT INTO `sys_district` VALUES ('2487', '那曲县', '285');
INSERT INTO `sys_district` VALUES ('2488', '嘉黎县', '285');
INSERT INTO `sys_district` VALUES ('2489', '比如县', '285');
INSERT INTO `sys_district` VALUES ('2490', '聂荣县', '285');
INSERT INTO `sys_district` VALUES ('2491', '安多县', '285');
INSERT INTO `sys_district` VALUES ('2492', '申扎县', '285');
INSERT INTO `sys_district` VALUES ('2493', '索县', '285');
INSERT INTO `sys_district` VALUES ('2494', '班戈县', '285');
INSERT INTO `sys_district` VALUES ('2495', '巴青县', '285');
INSERT INTO `sys_district` VALUES ('2496', '尼玛县', '285');
INSERT INTO `sys_district` VALUES ('2497', '普兰县', '286');
INSERT INTO `sys_district` VALUES ('2498', '札达县', '286');
INSERT INTO `sys_district` VALUES ('2499', '噶尔县', '286');
INSERT INTO `sys_district` VALUES ('2500', '日土县', '286');
INSERT INTO `sys_district` VALUES ('2501', '革吉县', '286');
INSERT INTO `sys_district` VALUES ('2502', '改则县', '286');
INSERT INTO `sys_district` VALUES ('2503', '措勤县', '286');
INSERT INTO `sys_district` VALUES ('2504', '林芝县', '287');
INSERT INTO `sys_district` VALUES ('2505', '工布江达县', '287');
INSERT INTO `sys_district` VALUES ('2506', '米林县', '287');
INSERT INTO `sys_district` VALUES ('2507', '墨脱县', '287');
INSERT INTO `sys_district` VALUES ('2508', '波密县', '287');
INSERT INTO `sys_district` VALUES ('2509', '察隅县', '287');
INSERT INTO `sys_district` VALUES ('2510', '朗县', '287');
INSERT INTO `sys_district` VALUES ('2511', '新城区', '288');
INSERT INTO `sys_district` VALUES ('2512', '碑林区', '288');
INSERT INTO `sys_district` VALUES ('2513', '莲湖区', '288');
INSERT INTO `sys_district` VALUES ('2514', '灞桥区', '288');
INSERT INTO `sys_district` VALUES ('2515', '未央区', '288');
INSERT INTO `sys_district` VALUES ('2516', '雁塔区', '288');
INSERT INTO `sys_district` VALUES ('2517', '阎良区', '288');
INSERT INTO `sys_district` VALUES ('2518', '临潼区', '288');
INSERT INTO `sys_district` VALUES ('2519', '长安区', '288');
INSERT INTO `sys_district` VALUES ('2520', '蓝田县', '288');
INSERT INTO `sys_district` VALUES ('2521', '周至县', '288');
INSERT INTO `sys_district` VALUES ('2522', '户县', '288');
INSERT INTO `sys_district` VALUES ('2523', '高陵县', '288');
INSERT INTO `sys_district` VALUES ('2524', '王益区', '289');
INSERT INTO `sys_district` VALUES ('2525', '印台区', '289');
INSERT INTO `sys_district` VALUES ('2526', '耀州区', '289');
INSERT INTO `sys_district` VALUES ('2527', '宜君县', '289');
INSERT INTO `sys_district` VALUES ('2528', '渭滨区', '290');
INSERT INTO `sys_district` VALUES ('2529', '金台区', '290');
INSERT INTO `sys_district` VALUES ('2530', '陈仓区', '290');
INSERT INTO `sys_district` VALUES ('2531', '凤翔县', '290');
INSERT INTO `sys_district` VALUES ('2532', '岐山县', '290');
INSERT INTO `sys_district` VALUES ('2533', '扶风县', '290');
INSERT INTO `sys_district` VALUES ('2534', '眉县', '290');
INSERT INTO `sys_district` VALUES ('2535', '陇县', '290');
INSERT INTO `sys_district` VALUES ('2536', '千阳县', '290');
INSERT INTO `sys_district` VALUES ('2537', '麟游县', '290');
INSERT INTO `sys_district` VALUES ('2538', '凤县', '290');
INSERT INTO `sys_district` VALUES ('2539', '太白县', '290');
INSERT INTO `sys_district` VALUES ('2540', '秦都区', '291');
INSERT INTO `sys_district` VALUES ('2541', '杨凌区', '291');
INSERT INTO `sys_district` VALUES ('2542', '渭城区', '291');
INSERT INTO `sys_district` VALUES ('2543', '三原县', '291');
INSERT INTO `sys_district` VALUES ('2544', '泾阳县', '291');
INSERT INTO `sys_district` VALUES ('2545', '乾县', '291');
INSERT INTO `sys_district` VALUES ('2546', '礼泉县', '291');
INSERT INTO `sys_district` VALUES ('2547', '永寿县', '291');
INSERT INTO `sys_district` VALUES ('2548', '彬县', '291');
INSERT INTO `sys_district` VALUES ('2549', '长武县', '291');
INSERT INTO `sys_district` VALUES ('2550', '旬邑县', '291');
INSERT INTO `sys_district` VALUES ('2551', '淳化县', '291');
INSERT INTO `sys_district` VALUES ('2552', '武功县', '291');
INSERT INTO `sys_district` VALUES ('2553', '兴平市', '291');
INSERT INTO `sys_district` VALUES ('2554', '临渭区', '292');
INSERT INTO `sys_district` VALUES ('2555', '华县', '292');
INSERT INTO `sys_district` VALUES ('2556', '潼关县', '292');
INSERT INTO `sys_district` VALUES ('2557', '大荔县', '292');
INSERT INTO `sys_district` VALUES ('2558', '合阳县', '292');
INSERT INTO `sys_district` VALUES ('2559', '澄城县', '292');
INSERT INTO `sys_district` VALUES ('2560', '蒲城县', '292');
INSERT INTO `sys_district` VALUES ('2561', '白水县', '292');
INSERT INTO `sys_district` VALUES ('2562', '富平县', '292');
INSERT INTO `sys_district` VALUES ('2563', '韩城市', '292');
INSERT INTO `sys_district` VALUES ('2564', '华阴市', '292');
INSERT INTO `sys_district` VALUES ('2565', '宝塔区', '293');
INSERT INTO `sys_district` VALUES ('2566', '延长县', '293');
INSERT INTO `sys_district` VALUES ('2567', '延川县', '293');
INSERT INTO `sys_district` VALUES ('2568', '子长县', '293');
INSERT INTO `sys_district` VALUES ('2569', '安塞县', '293');
INSERT INTO `sys_district` VALUES ('2570', '志丹县', '293');
INSERT INTO `sys_district` VALUES ('2571', '吴旗县', '293');
INSERT INTO `sys_district` VALUES ('2572', '甘泉县', '293');
INSERT INTO `sys_district` VALUES ('2573', '富县', '293');
INSERT INTO `sys_district` VALUES ('2574', '洛川县', '293');
INSERT INTO `sys_district` VALUES ('2575', '宜川县', '293');
INSERT INTO `sys_district` VALUES ('2576', '黄龙县', '293');
INSERT INTO `sys_district` VALUES ('2577', '黄陵县', '293');
INSERT INTO `sys_district` VALUES ('2578', '汉台区', '294');
INSERT INTO `sys_district` VALUES ('2579', '南郑县', '294');
INSERT INTO `sys_district` VALUES ('2580', '城固县', '294');
INSERT INTO `sys_district` VALUES ('2581', '洋县', '294');
INSERT INTO `sys_district` VALUES ('2582', '西乡县', '294');
INSERT INTO `sys_district` VALUES ('2583', '勉县', '294');
INSERT INTO `sys_district` VALUES ('2584', '宁强县', '294');
INSERT INTO `sys_district` VALUES ('2585', '略阳县', '294');
INSERT INTO `sys_district` VALUES ('2586', '镇巴县', '294');
INSERT INTO `sys_district` VALUES ('2587', '留坝县', '294');
INSERT INTO `sys_district` VALUES ('2588', '佛坪县', '294');
INSERT INTO `sys_district` VALUES ('2589', '榆阳区', '295');
INSERT INTO `sys_district` VALUES ('2590', '神木县', '295');
INSERT INTO `sys_district` VALUES ('2591', '府谷县', '295');
INSERT INTO `sys_district` VALUES ('2592', '横山县', '295');
INSERT INTO `sys_district` VALUES ('2593', '靖边县', '295');
INSERT INTO `sys_district` VALUES ('2594', '定边县', '295');
INSERT INTO `sys_district` VALUES ('2595', '绥德县', '295');
INSERT INTO `sys_district` VALUES ('2596', '米脂县', '295');
INSERT INTO `sys_district` VALUES ('2597', '佳县', '295');
INSERT INTO `sys_district` VALUES ('2598', '吴堡县', '295');
INSERT INTO `sys_district` VALUES ('2599', '清涧县', '295');
INSERT INTO `sys_district` VALUES ('2600', '子洲县', '295');
INSERT INTO `sys_district` VALUES ('2601', '汉滨区', '296');
INSERT INTO `sys_district` VALUES ('2602', '汉阴县', '296');
INSERT INTO `sys_district` VALUES ('2603', '石泉县', '296');
INSERT INTO `sys_district` VALUES ('2604', '宁陕县', '296');
INSERT INTO `sys_district` VALUES ('2605', '紫阳县', '296');
INSERT INTO `sys_district` VALUES ('2606', '岚皋县', '296');
INSERT INTO `sys_district` VALUES ('2607', '平利县', '296');
INSERT INTO `sys_district` VALUES ('2608', '镇坪县', '296');
INSERT INTO `sys_district` VALUES ('2609', '旬阳县', '296');
INSERT INTO `sys_district` VALUES ('2610', '白河县', '296');
INSERT INTO `sys_district` VALUES ('2611', '商州区', '297');
INSERT INTO `sys_district` VALUES ('2612', '洛南县', '297');
INSERT INTO `sys_district` VALUES ('2613', '丹凤县', '297');
INSERT INTO `sys_district` VALUES ('2614', '商南县', '297');
INSERT INTO `sys_district` VALUES ('2615', '山阳县', '297');
INSERT INTO `sys_district` VALUES ('2616', '镇安县', '297');
INSERT INTO `sys_district` VALUES ('2617', '柞水县', '297');
INSERT INTO `sys_district` VALUES ('2618', '城关区', '298');
INSERT INTO `sys_district` VALUES ('2619', '七里河区', '298');
INSERT INTO `sys_district` VALUES ('2620', '西固区', '298');
INSERT INTO `sys_district` VALUES ('2621', '安宁区', '298');
INSERT INTO `sys_district` VALUES ('2622', '红古区', '298');
INSERT INTO `sys_district` VALUES ('2623', '永登县', '298');
INSERT INTO `sys_district` VALUES ('2624', '皋兰县', '298');
INSERT INTO `sys_district` VALUES ('2625', '榆中县', '298');
INSERT INTO `sys_district` VALUES ('2626', '金川区', '300');
INSERT INTO `sys_district` VALUES ('2627', '永昌县', '300');
INSERT INTO `sys_district` VALUES ('2628', '白银区', '301');
INSERT INTO `sys_district` VALUES ('2629', '平川区', '301');
INSERT INTO `sys_district` VALUES ('2630', '靖远县', '301');
INSERT INTO `sys_district` VALUES ('2631', '会宁县', '301');
INSERT INTO `sys_district` VALUES ('2632', '景泰县', '301');
INSERT INTO `sys_district` VALUES ('2633', '秦城区', '302');
INSERT INTO `sys_district` VALUES ('2634', '北道区', '302');
INSERT INTO `sys_district` VALUES ('2635', '清水县', '302');
INSERT INTO `sys_district` VALUES ('2636', '秦安县', '302');
INSERT INTO `sys_district` VALUES ('2637', '甘谷县', '302');
INSERT INTO `sys_district` VALUES ('2638', '武山县', '302');
INSERT INTO `sys_district` VALUES ('2639', '张家川回族自治县', '302');
INSERT INTO `sys_district` VALUES ('2640', '凉州区', '303');
INSERT INTO `sys_district` VALUES ('2641', '民勤县', '303');
INSERT INTO `sys_district` VALUES ('2642', '古浪县', '303');
INSERT INTO `sys_district` VALUES ('2643', '天祝藏族自治县', '303');
INSERT INTO `sys_district` VALUES ('2644', '甘州区', '304');
INSERT INTO `sys_district` VALUES ('2645', '肃南裕固族自治县', '304');
INSERT INTO `sys_district` VALUES ('2646', '民乐县', '304');
INSERT INTO `sys_district` VALUES ('2647', '临泽县', '304');
INSERT INTO `sys_district` VALUES ('2648', '高台县', '304');
INSERT INTO `sys_district` VALUES ('2649', '山丹县', '304');
INSERT INTO `sys_district` VALUES ('2650', '崆峒区', '305');
INSERT INTO `sys_district` VALUES ('2651', '泾川县', '305');
INSERT INTO `sys_district` VALUES ('2652', '灵台县', '305');
INSERT INTO `sys_district` VALUES ('2653', '崇信县', '305');
INSERT INTO `sys_district` VALUES ('2654', '华亭县', '305');
INSERT INTO `sys_district` VALUES ('2655', '庄浪县', '305');
INSERT INTO `sys_district` VALUES ('2656', '静宁县', '305');
INSERT INTO `sys_district` VALUES ('2657', '肃州区', '306');
INSERT INTO `sys_district` VALUES ('2658', '金塔县', '306');
INSERT INTO `sys_district` VALUES ('2659', '安西县', '306');
INSERT INTO `sys_district` VALUES ('2660', '肃北蒙古族自治县', '306');
INSERT INTO `sys_district` VALUES ('2661', '阿克塞哈萨克族自治县', '306');
INSERT INTO `sys_district` VALUES ('2662', '玉门市', '306');
INSERT INTO `sys_district` VALUES ('2663', '敦煌市', '306');
INSERT INTO `sys_district` VALUES ('2664', '西峰区', '307');
INSERT INTO `sys_district` VALUES ('2665', '庆城县', '307');
INSERT INTO `sys_district` VALUES ('2666', '环县', '307');
INSERT INTO `sys_district` VALUES ('2667', '华池县', '307');
INSERT INTO `sys_district` VALUES ('2668', '合水县', '307');
INSERT INTO `sys_district` VALUES ('2669', '正宁县', '307');
INSERT INTO `sys_district` VALUES ('2670', '宁县', '307');
INSERT INTO `sys_district` VALUES ('2671', '镇原县', '307');
INSERT INTO `sys_district` VALUES ('2672', '安定区', '308');
INSERT INTO `sys_district` VALUES ('2673', '通渭县', '308');
INSERT INTO `sys_district` VALUES ('2674', '陇西县', '308');
INSERT INTO `sys_district` VALUES ('2675', '渭源县', '308');
INSERT INTO `sys_district` VALUES ('2676', '临洮县', '308');
INSERT INTO `sys_district` VALUES ('2677', '漳县', '308');
INSERT INTO `sys_district` VALUES ('2678', '岷县', '308');
INSERT INTO `sys_district` VALUES ('2679', '武都区', '309');
INSERT INTO `sys_district` VALUES ('2680', '成县', '309');
INSERT INTO `sys_district` VALUES ('2681', '文县', '309');
INSERT INTO `sys_district` VALUES ('2682', '宕昌县', '309');
INSERT INTO `sys_district` VALUES ('2683', '康县', '309');
INSERT INTO `sys_district` VALUES ('2684', '西和县', '309');
INSERT INTO `sys_district` VALUES ('2685', '礼县', '309');
INSERT INTO `sys_district` VALUES ('2686', '徽县', '309');
INSERT INTO `sys_district` VALUES ('2687', '两当县', '309');
INSERT INTO `sys_district` VALUES ('2688', '临夏市', '310');
INSERT INTO `sys_district` VALUES ('2689', '临夏县', '310');
INSERT INTO `sys_district` VALUES ('2690', '康乐县', '310');
INSERT INTO `sys_district` VALUES ('2691', '永靖县', '310');
INSERT INTO `sys_district` VALUES ('2692', '广河县', '310');
INSERT INTO `sys_district` VALUES ('2693', '和政县', '310');
INSERT INTO `sys_district` VALUES ('2694', '东乡族自治县', '310');
INSERT INTO `sys_district` VALUES ('2695', '积石山保安族东乡族撒拉族自治县', '310');
INSERT INTO `sys_district` VALUES ('2696', '合作市', '311');
INSERT INTO `sys_district` VALUES ('2697', '临潭县', '311');
INSERT INTO `sys_district` VALUES ('2698', '卓尼县', '311');
INSERT INTO `sys_district` VALUES ('2699', '舟曲县', '311');
INSERT INTO `sys_district` VALUES ('2700', '迭部县', '311');
INSERT INTO `sys_district` VALUES ('2701', '玛曲县', '311');
INSERT INTO `sys_district` VALUES ('2702', '碌曲县', '311');
INSERT INTO `sys_district` VALUES ('2703', '夏河县', '311');
INSERT INTO `sys_district` VALUES ('2704', '城东区', '312');
INSERT INTO `sys_district` VALUES ('2705', '城中区', '312');
INSERT INTO `sys_district` VALUES ('2706', '城西区', '312');
INSERT INTO `sys_district` VALUES ('2707', '城北区', '312');
INSERT INTO `sys_district` VALUES ('2708', '大通回族土族自治县', '312');
INSERT INTO `sys_district` VALUES ('2709', '湟中县', '312');
INSERT INTO `sys_district` VALUES ('2710', '湟源县', '312');
INSERT INTO `sys_district` VALUES ('2711', '平安县', '313');
INSERT INTO `sys_district` VALUES ('2712', '民和回族土族自治县', '313');
INSERT INTO `sys_district` VALUES ('2713', '乐都县', '313');
INSERT INTO `sys_district` VALUES ('2714', '互助土族自治县', '313');
INSERT INTO `sys_district` VALUES ('2715', '化隆回族自治县', '313');
INSERT INTO `sys_district` VALUES ('2716', '循化撒拉族自治县', '313');
INSERT INTO `sys_district` VALUES ('2717', '门源回族自治县', '314');
INSERT INTO `sys_district` VALUES ('2718', '祁连县', '314');
INSERT INTO `sys_district` VALUES ('2719', '海晏县', '314');
INSERT INTO `sys_district` VALUES ('2720', '刚察县', '314');
INSERT INTO `sys_district` VALUES ('2721', '同仁县', '315');
INSERT INTO `sys_district` VALUES ('2722', '尖扎县', '315');
INSERT INTO `sys_district` VALUES ('2723', '泽库县', '315');
INSERT INTO `sys_district` VALUES ('2724', '河南蒙古族自治县', '315');
INSERT INTO `sys_district` VALUES ('2725', '共和县', '316');
INSERT INTO `sys_district` VALUES ('2726', '同德县', '316');
INSERT INTO `sys_district` VALUES ('2727', '贵德县', '316');
INSERT INTO `sys_district` VALUES ('2728', '兴海县', '316');
INSERT INTO `sys_district` VALUES ('2729', '贵南县', '316');
INSERT INTO `sys_district` VALUES ('2730', '玛沁县', '317');
INSERT INTO `sys_district` VALUES ('2731', '班玛县', '317');
INSERT INTO `sys_district` VALUES ('2732', '甘德县', '317');
INSERT INTO `sys_district` VALUES ('2733', '达日县', '317');
INSERT INTO `sys_district` VALUES ('2734', '久治县', '317');
INSERT INTO `sys_district` VALUES ('2735', '玛多县', '317');
INSERT INTO `sys_district` VALUES ('2736', '玉树县', '318');
INSERT INTO `sys_district` VALUES ('2737', '杂多县', '318');
INSERT INTO `sys_district` VALUES ('2738', '称多县', '318');
INSERT INTO `sys_district` VALUES ('2739', '治多县', '318');
INSERT INTO `sys_district` VALUES ('2740', '囊谦县', '318');
INSERT INTO `sys_district` VALUES ('2741', '曲麻莱县', '318');
INSERT INTO `sys_district` VALUES ('2742', '格尔木市', '319');
INSERT INTO `sys_district` VALUES ('2743', '德令哈市', '319');
INSERT INTO `sys_district` VALUES ('2744', '乌兰县', '319');
INSERT INTO `sys_district` VALUES ('2745', '都兰县', '319');
INSERT INTO `sys_district` VALUES ('2746', '天峻县', '319');
INSERT INTO `sys_district` VALUES ('2747', '兴庆区', '320');
INSERT INTO `sys_district` VALUES ('2748', '西夏区', '320');
INSERT INTO `sys_district` VALUES ('2749', '金凤区', '320');
INSERT INTO `sys_district` VALUES ('2750', '永宁县', '320');
INSERT INTO `sys_district` VALUES ('2751', '贺兰县', '320');
INSERT INTO `sys_district` VALUES ('2752', '灵武市', '320');
INSERT INTO `sys_district` VALUES ('2753', '大武口区', '321');
INSERT INTO `sys_district` VALUES ('2754', '惠农区', '321');
INSERT INTO `sys_district` VALUES ('2755', '平罗县', '321');
INSERT INTO `sys_district` VALUES ('2756', '利通区', '322');
INSERT INTO `sys_district` VALUES ('2757', '盐池县', '322');
INSERT INTO `sys_district` VALUES ('2758', '同心县', '322');
INSERT INTO `sys_district` VALUES ('2759', '青铜峡市', '322');
INSERT INTO `sys_district` VALUES ('2760', '原州区', '323');
INSERT INTO `sys_district` VALUES ('2761', '西吉县', '323');
INSERT INTO `sys_district` VALUES ('2762', '隆德县', '323');
INSERT INTO `sys_district` VALUES ('2763', '泾源县', '323');
INSERT INTO `sys_district` VALUES ('2764', '彭阳县', '323');
INSERT INTO `sys_district` VALUES ('2765', '沙坡头区', '324');
INSERT INTO `sys_district` VALUES ('2766', '中宁县', '324');
INSERT INTO `sys_district` VALUES ('2767', '海原县', '324');
INSERT INTO `sys_district` VALUES ('2768', '天山区', '325');
INSERT INTO `sys_district` VALUES ('2769', '沙依巴克区', '325');
INSERT INTO `sys_district` VALUES ('2770', '新市区', '325');
INSERT INTO `sys_district` VALUES ('2771', '水磨沟区', '325');
INSERT INTO `sys_district` VALUES ('2772', '头屯河区', '325');
INSERT INTO `sys_district` VALUES ('2773', '达坂城区', '325');
INSERT INTO `sys_district` VALUES ('2774', '东山区', '325');
INSERT INTO `sys_district` VALUES ('2775', '乌鲁木齐县', '325');
INSERT INTO `sys_district` VALUES ('2776', '独山子区', '326');
INSERT INTO `sys_district` VALUES ('2777', '克拉玛依区', '326');
INSERT INTO `sys_district` VALUES ('2778', '白碱滩区', '326');
INSERT INTO `sys_district` VALUES ('2779', '乌尔禾区', '326');
INSERT INTO `sys_district` VALUES ('2780', '吐鲁番市', '327');
INSERT INTO `sys_district` VALUES ('2781', '鄯善县', '327');
INSERT INTO `sys_district` VALUES ('2782', '托克逊县', '327');
INSERT INTO `sys_district` VALUES ('2783', '哈密市', '328');
INSERT INTO `sys_district` VALUES ('2784', '巴里坤哈萨克自治县', '328');
INSERT INTO `sys_district` VALUES ('2785', '伊吾县', '328');
INSERT INTO `sys_district` VALUES ('2786', '昌吉市', '329');
INSERT INTO `sys_district` VALUES ('2787', '阜康市', '329');
INSERT INTO `sys_district` VALUES ('2788', '米泉市', '329');
INSERT INTO `sys_district` VALUES ('2789', '呼图壁县', '329');
INSERT INTO `sys_district` VALUES ('2790', '玛纳斯县', '329');
INSERT INTO `sys_district` VALUES ('2791', '奇台县', '329');
INSERT INTO `sys_district` VALUES ('2792', '吉木萨尔县', '329');
INSERT INTO `sys_district` VALUES ('2793', '木垒哈萨克自治县', '329');
INSERT INTO `sys_district` VALUES ('2794', '博乐市', '330');
INSERT INTO `sys_district` VALUES ('2795', '精河县', '330');
INSERT INTO `sys_district` VALUES ('2796', '温泉县', '330');
INSERT INTO `sys_district` VALUES ('2797', '库尔勒市', '331');
INSERT INTO `sys_district` VALUES ('2798', '轮台县', '331');
INSERT INTO `sys_district` VALUES ('2799', '尉犁县', '331');
INSERT INTO `sys_district` VALUES ('2800', '若羌县', '331');
INSERT INTO `sys_district` VALUES ('2801', '且末县', '331');
INSERT INTO `sys_district` VALUES ('2802', '焉耆回族自治县', '331');
INSERT INTO `sys_district` VALUES ('2803', '和静县', '331');
INSERT INTO `sys_district` VALUES ('2804', '和硕县', '331');
INSERT INTO `sys_district` VALUES ('2805', '博湖县', '331');
INSERT INTO `sys_district` VALUES ('2806', '阿克苏市', '332');
INSERT INTO `sys_district` VALUES ('2807', '温宿县', '332');
INSERT INTO `sys_district` VALUES ('2808', '库车县', '332');
INSERT INTO `sys_district` VALUES ('2809', '沙雅县', '332');
INSERT INTO `sys_district` VALUES ('2810', '新和县', '332');
INSERT INTO `sys_district` VALUES ('2811', '拜城县', '332');
INSERT INTO `sys_district` VALUES ('2812', '乌什县', '332');
INSERT INTO `sys_district` VALUES ('2813', '阿瓦提县', '332');
INSERT INTO `sys_district` VALUES ('2814', '柯坪县', '332');
INSERT INTO `sys_district` VALUES ('2815', '阿图什市', '333');
INSERT INTO `sys_district` VALUES ('2816', '阿克陶县', '333');
INSERT INTO `sys_district` VALUES ('2817', '阿合奇县', '333');
INSERT INTO `sys_district` VALUES ('2818', '乌恰县', '333');
INSERT INTO `sys_district` VALUES ('2819', '喀什市', '334');
INSERT INTO `sys_district` VALUES ('2820', '疏附县', '334');
INSERT INTO `sys_district` VALUES ('2821', '疏勒县', '334');
INSERT INTO `sys_district` VALUES ('2822', '英吉沙县', '334');
INSERT INTO `sys_district` VALUES ('2823', '泽普县', '334');
INSERT INTO `sys_district` VALUES ('2824', '莎车县', '334');
INSERT INTO `sys_district` VALUES ('2825', '叶城县', '334');
INSERT INTO `sys_district` VALUES ('2826', '麦盖提县', '334');
INSERT INTO `sys_district` VALUES ('2827', '岳普湖县', '334');
INSERT INTO `sys_district` VALUES ('2828', '伽师县', '334');
INSERT INTO `sys_district` VALUES ('2829', '巴楚县', '334');
INSERT INTO `sys_district` VALUES ('2830', '塔什库尔干塔吉克自治县', '334');
INSERT INTO `sys_district` VALUES ('2831', '和田市', '335');
INSERT INTO `sys_district` VALUES ('2832', '和田县', '335');
INSERT INTO `sys_district` VALUES ('2833', '墨玉县', '335');
INSERT INTO `sys_district` VALUES ('2834', '皮山县', '335');
INSERT INTO `sys_district` VALUES ('2835', '洛浦县', '335');
INSERT INTO `sys_district` VALUES ('2836', '策勒县', '335');
INSERT INTO `sys_district` VALUES ('2837', '于田县', '335');
INSERT INTO `sys_district` VALUES ('2838', '民丰县', '335');
INSERT INTO `sys_district` VALUES ('2839', '伊宁市', '336');
INSERT INTO `sys_district` VALUES ('2840', '奎屯市', '336');
INSERT INTO `sys_district` VALUES ('2841', '伊宁县', '336');
INSERT INTO `sys_district` VALUES ('2842', '察布查尔锡伯自治县', '336');
INSERT INTO `sys_district` VALUES ('2843', '霍城县', '336');
INSERT INTO `sys_district` VALUES ('2844', '巩留县', '336');
INSERT INTO `sys_district` VALUES ('2845', '新源县', '336');
INSERT INTO `sys_district` VALUES ('2846', '昭苏县', '336');
INSERT INTO `sys_district` VALUES ('2847', '特克斯县', '336');
INSERT INTO `sys_district` VALUES ('2848', '尼勒克县', '336');
INSERT INTO `sys_district` VALUES ('2849', '塔城市', '337');
INSERT INTO `sys_district` VALUES ('2850', '乌苏市', '337');
INSERT INTO `sys_district` VALUES ('2851', '额敏县', '337');
INSERT INTO `sys_district` VALUES ('2852', '沙湾县', '337');
INSERT INTO `sys_district` VALUES ('2853', '托里县', '337');
INSERT INTO `sys_district` VALUES ('2854', '裕民县', '337');
INSERT INTO `sys_district` VALUES ('2855', '和布克赛尔蒙古自治县', '337');
INSERT INTO `sys_district` VALUES ('2856', '阿勒泰市', '338');
INSERT INTO `sys_district` VALUES ('2857', '布尔津县', '338');
INSERT INTO `sys_district` VALUES ('2858', '富蕴县', '338');
INSERT INTO `sys_district` VALUES ('2859', '福海县', '338');
INSERT INTO `sys_district` VALUES ('2860', '哈巴河县', '338');
INSERT INTO `sys_district` VALUES ('2861', '青河县', '338');
INSERT INTO `sys_district` VALUES ('2862', '吉木乃县', '338');

-- ----------------------------
-- Table structure for `sys_file`
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file` (
  `id` varchar(255) NOT NULL COMMENT '主键ID',
  `system_id` varchar(255) DEFAULT NULL COMMENT '系统ID',
  `file_unique_index` varchar(255) DEFAULT NULL COMMENT '文件唯一索引',
  `origin_file_name` varchar(255) DEFAULT NULL COMMENT '原始文件名称',
  `current_file_name` varchar(255) DEFAULT NULL COMMENT '现文件名称',
  `file_path` varchar(255) DEFAULT NULL COMMENT '文件路径',
  `file_full_path` varchar(255) DEFAULT NULL COMMENT '文件全路径',
  `file_suffix` varchar(255) DEFAULT NULL COMMENT '文件后缀',
  `file_size` bigint(19) DEFAULT NULL COMMENT '文件大小',
  `file_unit` varchar(255) DEFAULT NULL COMMENT '文件大小单位',
  `file_ser_no` varchar(255) DEFAULT NULL COMMENT '文件批次号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` int(11) DEFAULT '0' COMMENT '状态(0:正常；1：禁用)',
  `file_use_type` int(11) DEFAULT NULL COMMENT '文件使用类型（1：临时文件；2：正式文件）',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(255) DEFAULT NULL COMMENT '创建者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新者',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '删除标记(0:未被删除;1:已被删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统文件表';

-- ----------------------------
-- Records of sys_file
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_interfaces`
-- ----------------------------
DROP TABLE IF EXISTS `sys_interfaces`;
CREATE TABLE `sys_interfaces` (
  `id` varchar(255) NOT NULL COMMENT '主键ID',
  `name` varchar(255) DEFAULT NULL COMMENT '接口名称',
  `url` varchar(255) DEFAULT NULL COMMENT 'URL',
  `class_method` varchar(255) DEFAULT NULL COMMENT '类名方法名',
  `auth` varchar(255) DEFAULT NULL COMMENT '访问权限',
  `method` varchar(255) DEFAULT NULL COMMENT '方法名称',
  `times` varchar(255) DEFAULT NULL COMMENT '时间',
  `unit` varchar(255) DEFAULT NULL COMMENT '单位',
  `counts` varchar(255) DEFAULT NULL COMMENT '次数',
  `data_permission` tinyint(4) DEFAULT NULL COMMENT '数据权限（0:无数据权限；1：有数据权限）',
  `log_record` tinyint(4) DEFAULT NULL COMMENT '日志记录（0:不记录；1：记录）',
  `entity` varchar(255) DEFAULT NULL COMMENT '返回的实体类（主要数据对象）',
  `history_times` bigint(20) unsigned DEFAULT '0' COMMENT '历史接口被调用次数',
  `request_data_secret` tinyint(4) DEFAULT NULL COMMENT '求数据加密（0：不加密；1：加密）',
  `response_data_secret` tinyint(4) DEFAULT NULL COMMENT '返回数据加密（0：不加密；1：加密）',
  `level` tinyint(4) DEFAULT '0' COMMENT '接口等级（数字越大等级越高，默认0无等级）',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(255) DEFAULT NULL COMMENT '创建者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新者',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '删除标记(0:未被删除;1:已被删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统接口表';

-- ----------------------------
-- Records of sys_interfaces
-- ----------------------------
INSERT INTO `sys_interfaces` VALUES ('202005161425050731', '用户登录接口', '/webLogin', 'com.javaweb.web.controller.AllOpenController#webLogin', 'NO_LOGIN', 'POST', null, null, null, '0', '0', null, '304', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425050781', '获取服务器时间接口', '/getServeTime', 'com.javaweb.web.controller.AllOpenController#getServeTime', 'NO_LOGIN', 'GET', null, null, null, '0', '0', null, '681', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425050801', '请求失效接口', '/invalidRequest', 'com.javaweb.web.controller.AllOpenController#invalidRequest', 'NO_LOGIN', 'GET, POST, PUT, DELETE', null, null, null, '0', '0', null, '0', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425050821', '请求接口不存在接口', '/notFound', 'com.javaweb.web.controller.AllOpenController#notFound', 'NO_LOGIN', 'GET, POST, PUT, DELETE', null, null, null, '0', '0', null, '0', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425050841', '没有权限接口', '/noAuthory', 'com.javaweb.web.controller.AllOpenController#noAuthory', 'NO_LOGIN', 'GET, POST, PUT, DELETE', null, null, null, '0', '0', null, '0', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425050861', '系统异常接口', '/internalError', 'com.javaweb.web.controller.AllOpenController#internalError', 'NO_LOGIN', 'GET, POST, PUT, DELETE', null, null, null, '0', '0', null, '0', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425050881', '请求参数缺失接口', '/requestParameterLost', 'com.javaweb.web.controller.AllOpenController#requestParameterLost', 'NO_LOGIN', 'GET, POST, PUT, DELETE', null, null, null, '0', '0', null, '0', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425050901', '请求参数错误接口', '/requestParameterError', 'com.javaweb.web.controller.AllOpenController#requestParameterError', 'NO_LOGIN', 'GET, POST, PUT, DELETE', null, null, null, '0', '0', null, '0', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425050921', '数据库表详情接口', '/web/sys/dbTables/detail/{tableName}', 'com.javaweb.web.controller.DbTablesController#dbTablesDetail', 'PERMISSION', 'GET', null, null, null, '0', '0', null, '4', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425050941', '数据库表列表接口', '/web/sys/dbTables/list', 'com.javaweb.web.controller.DbTablesController#dbTablesList', 'PERMISSION', 'POST', null, null, null, '0', '0', null, '119', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425050961', '数据库表代码生成接口', '/web/sys/dbTables/codeGenerate/{tableName}', 'com.javaweb.web.controller.DbTablesController#dbTablesCodeGenerate', 'PERMISSION', 'GET', null, null, null, '0', '1', null, '1', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425050981', '查询字典接口', '/web/sys/dictionary/list', 'com.javaweb.web.controller.DictionaryController#dictionaryList', 'PERMISSION', 'POST', null, null, null, '0', '0', null, '90', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051001', '修改字典接口', '/web/sys/dictionary/modify', 'com.javaweb.web.controller.DictionaryController#dictionaryModify', 'PERMISSION', 'PUT', null, null, null, '0', '1', null, '1', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051021', '删除字典接口（支持批量删除，用逗号隔开）', '/web/sys/dictionary/delete/{dictionaryId}', 'com.javaweb.web.controller.DictionaryController#dictionaryDelete', 'PERMISSION', 'DELETE', null, null, null, '0', '1', null, '4', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051041', '新增字典接口', '/web/sys/dictionary/add', 'com.javaweb.web.controller.DictionaryController#dictionaryAdd', 'PERMISSION', 'POST', null, null, null, '0', '1', null, '6', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051061', '字典详情接口', '/web/sys/dictionary/detail/{dictionaryId}', 'com.javaweb.web.controller.DictionaryController#dictionaryDetail', 'PERMISSION', 'GET', null, null, null, '0', '0', null, '7', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051081', '接口列表接口', '/web/sys/interfaces/list', 'com.javaweb.web.controller.InterfacesController#interfacesList', 'PERMISSION', 'POST', null, null, null, '0', '0', null, '269', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051131', '接口详情接口', '/web/sys/interfaces/detail/{interfacesId}', 'com.javaweb.web.controller.InterfacesController#interfacesDetail', 'PERMISSION', 'GET', null, null, null, '0', '0', null, '10', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051181', '修改接口接口', '/web/sys/interfaces/modify', 'com.javaweb.web.controller.InterfacesController#interfacesModify', 'PERMISSION', 'PUT', null, null, null, '0', '1', null, '17', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051201', '用户角色数据权限接口', '/web/sys/interfaces/userRoleDataPermission', 'com.javaweb.web.controller.InterfacesController#userRoleDataPermission', 'PERMISSION', 'POST', null, null, null, '0', '0', null, '50', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051221', '数据权限分配接口', '/web/sys/interfaces/dataPermissionAssignment/{interfacesId}', 'com.javaweb.web.controller.InterfacesController#dataPermissionAssignment', 'PERMISSION', 'POST', null, null, null, '0', '1', null, '1', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051241', '用户登出接口', '/web/loginAccess/logout', 'com.javaweb.web.controller.LoginAccessController#logout', 'LOGIN', 'GET', null, null, null, '0', '0', null, '173', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051261', '获得字典信息接口', '/web/loginAccess/getDictionary', 'com.javaweb.web.controller.LoginAccessController#getDictionary', 'LOGIN', 'POST', null, null, null, '0', '0', null, '342', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051281', '获取redis中的token信息接口', '/web/loginAccess/getRedisTokenData', 'com.javaweb.web.controller.LoginAccessController#getRedisTokenData', 'LOGIN', 'GET', null, null, null, '0', '0', null, '283', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051291', '查询模块接口', '/web/sys/module/list', 'com.javaweb.web.controller.ModuleController#moduleList', 'PERMISSION', 'POST', null, null, null, '0', '0', null, '155', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051311', '修改模块接口', '/web/sys/module/modify', 'com.javaweb.web.controller.ModuleController#moduleModify', 'PERMISSION', 'PUT', null, null, null, '0', '1', null, '1', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051331', '模块详情接口', '/web/sys/module/detail/{moduleId}', 'com.javaweb.web.controller.ModuleController#moduleDetail', 'PERMISSION', 'GET', null, null, null, '0', '0', null, '13', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051351', '新增模块接口', '/web/sys/module/add', 'com.javaweb.web.controller.ModuleController#moduleAdd', 'PERMISSION', 'POST', null, null, null, '0', '1', null, '24', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051371', '删除模块接口（支持批量删除，用逗号隔开）', '/web/sys/module/delete/{moduleId}', 'com.javaweb.web.controller.ModuleController#moduleDelete', 'PERMISSION', 'DELETE', null, null, null, '0', '1', null, '17', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051391', '获取模块ID和模块名称列表接口', '/web/sys/module/getModuleIdAndNameList/{moduleType}', 'com.javaweb.web.controller.ModuleController#getModuleIdAndNameList', 'PERMISSION', 'GET', null, null, null, '0', '0', null, '69', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051411', '在线用户列表接口', '/web/sys/onlineUser/list', 'com.javaweb.web.controller.OnlineUserController#list', 'PERMISSION', 'POST', null, null, null, '0', '0', null, '32', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051441', '用户下线接口', '/web/sys/onlineUser/offline/{key}', 'com.javaweb.web.controller.OnlineUserController#offline', 'PERMISSION', 'GET', null, null, null, '0', '1', null, '0', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051461', '查询操作日志接口', '/web/sys/operationLog/list', 'com.javaweb.web.controller.OperationLogController#operationLogList', 'PERMISSION', 'POST', null, null, null, '0', '0', null, '49', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051621', '日程列表接口', '/web/sys/schedule/list', 'com.javaweb.web.controller.ScheduleController#scheduleList', 'PERMISSION', 'POST', null, null, null, '0', '0', null, '85', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051651', '保存日程接口', '/web/sys/schedule/add', 'com.javaweb.web.controller.ScheduleController#scheduleAdd', 'PERMISSION', 'POST', null, null, null, '0', '1', null, '11', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051741', '修改用户接口', '/web/sys/user/modify', 'com.javaweb.web.controller.UserController#userModify', 'PERMISSION', 'PUT', null, null, null, '0', '1', null, '9', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051761', '删除用户接口（支持批量删除，用逗号隔开）', '/web/sys/user/delete/{userId}', 'com.javaweb.web.controller.UserController#userDelete', 'PERMISSION', 'DELETE', null, null, null, '0', '1', null, '10', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051821', '查询用户接口', '/web/sys/user/list', 'com.javaweb.web.controller.UserController#userList', 'PERMISSION', 'POST', '1', '秒', '3', '1', '0', '[userId, userName, personName, status, createDate, roleName, province, city, district]', '517', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051841', '用户详情接口', '/web/sys/user/detail/{userId}', 'com.javaweb.web.controller.UserController#userDetail', 'PERMISSION', 'GET', null, null, null, '0', '0', null, '35', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051861', '初始化密码接口', '/web/sys/user/initPassword/{userId}', 'com.javaweb.web.controller.UserController#userInitPassword', 'PERMISSION', 'GET', null, null, null, '0', '1', null, '3', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051881', '新增用户接口', '/web/sys/user/add', 'com.javaweb.web.controller.UserController#userAdd', 'PERMISSION', 'POST', null, null, null, '0', '1', null, '107', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202005161425051921', '用户角色分配接口', '/web/sys/user/userRoleAssignment/{userId}', 'com.javaweb.web.controller.UserController#userRoleAssignment', 'PERMISSION', 'POST', null, null, null, '0', '1', null, '8', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202006131245542761', '接口测试接口', '/web/sys/interfaces/test', 'com.javaweb.web.controller.InterfacesController#interfacesTest', 'PERMISSION', 'POST', null, null, null, '0', '1', null, '0', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202012231534471661', '文件列表接口', '/web/sys/file/list', 'com.javaweb.web.controller.FileController#list', 'PERMISSION', 'POST', null, null, null, '0', '0', null, '12', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202012231534471691', '文件下载接口', '/web/sys/file/downloadFile/{fileId}', 'com.javaweb.web.controller.FileController#downloadFile', 'PERMISSION', 'GET', null, null, null, '0', '1', null, '0', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202012231534471701', '文件上传接口', '/web/sys/file/uploadFile', 'com.javaweb.web.controller.FileController#uploadFile', 'PERMISSION', 'POST', null, null, null, '0', '1', null, '0', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202012231958062701', '文件删除接口', '/web/sys/file/delete/{fileId}', 'com.javaweb.web.controller.FileController#delete', 'PERMISSION', 'GET', null, null, null, '0', '1', null, '0', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202012231958062731', '文件详情接口', '/web/sys/file/detail/{fileId}', 'com.javaweb.web.controller.FileController#detail', 'PERMISSION', 'GET', null, null, null, '0', '1', null, '0', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202101141522555221', '请求接口受限接口', '/requestLimit', 'com.javaweb.web.controller.AllOpenController#requestLimit', 'NO_LOGIN', 'GET, POST, PUT, DELETE', null, null, null, '0', '0', null, '0', '0', '0', '0', null, '2021-01-29 09:51:49', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202103041321423671', '文件目录列表接口', '/web/sys/file/contentList', 'com.javaweb.web.controller.FileController#contentList', 'PERMISSION', 'POST', null, null, null, '0', '0', null, '12', '0', '0', '0', null, '2021-03-04 13:21:42', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202103041434555061', '文件根路径接口', '/web/sys/file/fileRootPath', 'com.javaweb.web.controller.FileController#fileRootPath', 'PERMISSION', 'GET', null, null, null, '0', '0', null, '12', '0', '0', '0', null, '2021-03-04 14:34:55', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202104220959454421', '缺失@ControllerMethod_202201130909400081', '/error', 'org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController#error', 'NO_LOGIN', '', null, null, null, '0', '0', null, '9', '0', '0', '0', null, '2021-04-22 09:59:45', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202107131445063681', '数据库表还原', '/web/sys/dbTables/reduction', 'com.javaweb.web.controller.DbTablesController#dbTablesReduction', 'PERMISSION', 'GET', null, null, null, '0', '0', null, '7', '0', '0', '0', null, '2021-07-13 14:45:06', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202110010956094551', '新增角色接口', '/web/sys/role/add', 'com.javaweb.web.controller.RoleController#roleAdd', 'PERMISSION', 'POST', null, null, null, '0', '0', null, '14', '0', '0', '0', null, '2021-10-01 09:56:09', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202110010956094571', '查询角色接口', '/web/sys/role/list', 'com.javaweb.web.controller.RoleController#roleList', 'PERMISSION', 'POST', null, null, null, '0', '0', null, '157', '0', '0', '0', null, '2021-10-01 09:56:09', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202110010956094591', '角色详情接口', '/web/sys/role/detail/{roleId}', 'com.javaweb.web.controller.RoleController#roleDetail', 'PERMISSION', 'GET', null, null, null, '0', '0', null, '21', '0', '0', '0', null, '2021-10-01 09:56:09', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202110010956094631', '修改角色接口', '/web/sys/role/modify', 'com.javaweb.web.controller.RoleController#roleModify', 'PERMISSION', 'PUT', null, null, null, '0', '0', null, '6', '0', '0', '0', null, '2021-10-01 09:56:09', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202110010956094651', '删除角色接口（支持批量删除，用逗号隔开）', '/web/sys/role/delete/{roleId}', 'com.javaweb.web.controller.RoleController#roleDelete', 'PERMISSION', 'DELETE', null, null, null, '0', '0', null, '12', '0', '0', '0', null, '2021-10-01 09:56:09', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202110010956094671', '角色模块分配接口', '/web/sys/role/roleModuleAssignment/{roleId}', 'com.javaweb.web.controller.RoleController#roleModuleAssignment', 'PERMISSION', 'POST', null, null, null, '0', '0', null, '3', '0', '0', '0', null, '2021-10-01 09:56:09', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202110221110318771', '查询配置接口', '/web/sys/config/list', 'com.javaweb.web.controller.ConfigController#configList', 'PERMISSION', 'POST', null, null, null, '0', '0', null, '56', '0', '0', '0', null, '2021-10-22 11:10:32', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202110221110318791', '新增配置接口', '/web/sys/config/add', 'com.javaweb.web.controller.ConfigController#configAdd', 'PERMISSION', 'POST', null, null, null, '0', '0', null, '5', '0', '0', '0', null, '2021-10-22 11:10:32', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202110221110318811', '删除配置接口（支持批量删除，用逗号隔开）', '/web/sys/config/delete/{configId}', 'com.javaweb.web.controller.ConfigController#configDelete', 'PERMISSION', 'DELETE', null, null, null, '0', '0', null, '4', '0', '0', '0', null, '2021-10-22 11:10:32', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202110221110318831', '配置详情接口', '/web/sys/config/detail/{configId}', 'com.javaweb.web.controller.ConfigController#configDetail', 'PERMISSION', 'GET', null, null, null, '0', '0', null, '6', '0', '0', '0', null, '2021-10-22 11:10:32', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202110221110318841', '修改配置接口', '/web/sys/config/modify', 'com.javaweb.web.controller.ConfigController#configModify', 'PERMISSION', 'PUT', null, null, null, '0', '0', null, '2', '0', '0', '0', null, '2021-10-22 11:10:32', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202111161523175191', '用户角色信息接口', '/web/sys/user/userRoleInfo/{userId}', 'com.javaweb.web.controller.UserController#userRoleInfo', 'PERMISSION', 'GET', null, null, null, '0', '0', null, '14', '0', '0', '0', null, '2021-11-16 15:23:18', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202111161535069441', '用户模块分配接口', '/web/sys/user/userModuleAssignment', 'com.javaweb.web.controller.UserController#userModuleAssignment', 'PERMISSION', 'POST', null, null, null, '0', '0', null, '6', '0', '0', '0', null, '2021-11-16 15:35:07', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202111161545415291', '用户模块信息接口', '/web/sys/user/userModuleInfo/{userId}', 'com.javaweb.web.controller.UserController#userModuleInfo', 'PERMISSION', 'GET', null, null, null, '0', '0', null, '14', '0', '0', '0', null, '2021-11-16 15:45:42', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202111161615275571', '角色模块信息接口', '/web/sys/role/roleModuleInfo/{roleId}', 'com.javaweb.web.controller.RoleController#roleModuleInfo', 'PERMISSION', 'GET', null, null, null, '0', '0', null, '6', '0', '0', '0', null, '2021-11-16 16:15:28', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202111211115335911', '新增角色限定接口', '/web/sys/roleRestrict/add', 'com.javaweb.web.controller.RoleRestrictController#roleRestrictAdd', 'PERMISSION', 'POST', null, null, null, '0', '0', null, '13', '0', '0', '0', null, '2021-11-21 11:15:34', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202111241758257101', '删除角色限定接口（支持批量删除，用逗号隔开）', '/web/sys/roleRestrict/delete/{roleRestrictId}', 'com.javaweb.web.controller.RoleRestrictController#roleRestrictDelete', 'PERMISSION', 'DELETE', null, null, null, '0', '0', null, '3', '0', '0', '0', null, '2021-11-24 17:58:26', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202111241758257121', '修改角色限定接口', '/web/sys/roleRestrict/modify', 'com.javaweb.web.controller.RoleRestrictController#roleRestrictModify', 'PERMISSION', 'POST', null, null, null, '0', '0', null, '0', '0', '0', '0', null, '2021-11-24 17:58:26', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202111241758257141', '角色限定详情接口', '/web/sys/roleRestrict/detail/{roleRestrictId}', 'com.javaweb.web.controller.RoleRestrictController#roleRestrictDetail', 'PERMISSION', 'GET', null, null, null, '0', '0', null, '0', '0', '0', '0', null, '2021-11-24 17:58:26', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202111241758257161', '查询角色限定接口', '/web/sys/roleRestrict/list', 'com.javaweb.web.controller.RoleRestrictController#roleRestrictList', 'PERMISSION', 'POST', null, null, null, '0', '0', null, '103', '0', '0', '0', null, '2021-11-24 17:58:26', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202111251346138381', '角色列表接口', '/web/sys/role/listAll', 'com.javaweb.web.controller.RoleController#roleListAll', 'PERMISSION', 'GET', null, null, null, '0', '0', null, '14', '0', '0', '0', null, '2021-11-25 13:46:14', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202112111144149741', '获得市信息接口（角色限定）', '/web/sys/roleRestrict/getCity/{provinceCode}', 'com.javaweb.web.controller.RoleRestrictController#getCityRoleRestrict', 'PERMISSION', 'GET', null, null, null, '0', '0', null, '2', '0', '0', '0', null, '2021-12-11 11:44:15', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202112111144149771', '获得区信息接口（角色限定）', '/web/sys/roleRestrict/getDistrict/{cityCode}', 'com.javaweb.web.controller.RoleRestrictController#getDistrictRoleRestrict', 'PERMISSION', 'GET', null, null, null, '0', '0', null, '1', '0', '0', '0', null, '2021-12-11 11:44:15', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202112111144149801', '获得省信息接口（角色限定）', '/web/sys/roleRestrict/getProvince', 'com.javaweb.web.controller.RoleRestrictController#getProvinceRoleRestrict', 'PERMISSION', 'GET', null, null, null, '0', '0', null, '9', '0', '0', '0', null, '2021-12-11 11:44:15', '-1', '2022-01-13 09:09:40', '-1', '0');
INSERT INTO `sys_interfaces` VALUES ('202201121751243341', '数据库操作', '/web/sys/dbTables/operate', 'com.javaweb.web.controller.DbTablesController#dbTablesOperate', 'PERMISSION', 'POST', null, null, null, '0', '0', null, '4', '0', '0', '0', null, '2022-01-12 17:51:24', '-1', '2022-01-13 09:09:40', '-1', '0');

-- ----------------------------
-- Table structure for `sys_interfaces_statistics`
-- ----------------------------
DROP TABLE IF EXISTS `sys_interfaces_statistics`;
CREATE TABLE `sys_interfaces_statistics` (
  `id` varchar(255) NOT NULL COMMENT '主键ID',
  `url` varchar(255) NOT NULL COMMENT 'URL',
  `year_month_day` varchar(255) NOT NULL COMMENT '年月日',
  `year` varchar(255) NOT NULL COMMENT '年',
  `month` varchar(255) NOT NULL COMMENT '月',
  `day` varchar(255) NOT NULL COMMENT '日',
  `insert_time` datetime NOT NULL COMMENT '插入时间',
  `times` bigint(20) NOT NULL COMMENT '次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统接口统计表';

-- ----------------------------
-- Records of sys_interfaces_statistics
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_module`
-- ----------------------------
DROP TABLE IF EXISTS `sys_module`;
CREATE TABLE `sys_module` (
  `module_id` varchar(255) NOT NULL COMMENT '主键ID',
  `module_name` varchar(255) NOT NULL COMMENT '模块名称',
  `page_url` varchar(255) DEFAULT NULL COMMENT '页面URL',
  `api_url` varchar(5000) DEFAULT NULL COMMENT 'API的URL',
  `api_sign` varchar(5000) DEFAULT NULL COMMENT 'API的URL',
  `parent_id` varchar(255) DEFAULT NULL COMMENT '模块的上级ID',
  `fcode` varchar(255) DEFAULT NULL COMMENT '层级关系',
  `level` int(11) DEFAULT NULL COMMENT '第几级(0表示未定义层级数;层级数1为最高,即根节点)',
  `orders` int(11) DEFAULT NULL COMMENT '模块顺序(0表示没有顺序;顺序从1开始)',
  `module_type` int(11) DEFAULT NULL COMMENT '模块类型(0:未定义模块类型;1:目录;2:菜单；3:功能)',
  `alias` varchar(255) DEFAULT NULL COMMENT '别名',
  `parent_alias` varchar(255) DEFAULT NULL COMMENT '上级别名',
  `system_id` varchar(255) DEFAULT NULL COMMENT '系统ID',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `type` int(11) DEFAULT NULL COMMENT '类型(0:未定义类型,作为全端通用接口使用;1:PC端;2:安卓端;3:IOS端) ',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(255) DEFAULT NULL COMMENT '创建者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新者',
  `del_flag` tinyint(4) DEFAULT NULL COMMENT '删除标记(0:未被删除;1:已被删除)',
  PRIMARY KEY (`module_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统模块表';

-- ----------------------------
-- Records of sys_module
-- ----------------------------
INSERT INTO `sys_module` VALUES ('202003282108350611', '系统管理', null, null, null, null, null, '1', '1', '1', 'sys', null, '1', null, 'minus-square', '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282108350781', '用户管理', '/web/sys/user', null, null, '202003282108350611', null, '2', '1', '2', 'sys:user', null, '1', null, 'plus-square', '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282108350791', '角色管理', '/web/sys/role', null, null, '202003282108350611', null, '2', '2', '2', 'sys:role', null, '1', null, 'clock-circle', '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282108350801', '模块管理', '/web/sys/module', null, null, '202003282108350611', null, '2', '4', '2', 'sys:module', null, '1', null, 'font-size', '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282108350802', '字典管理', '/web/sys/dictionary', null, null, '202003282108350611', null, '2', '5', '2', 'sys:dictionary', null, '1', null, 'bar-chart', '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282108350803', '操作日志管理', '/web/sys/operationLog', null, null, '202003282108350611', null, '2', '14', '2', 'sys:operationLog', null, '1', null, 'box-plot', '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282108350804', '日程管理', '/web/sys/schedule', null, null, '202003282108350611', null, '2', '6', '2', 'sys:schedule', null, '1', null, 'windows', '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282108350805', '接口管理', '/web/sys/interfaces', null, null, '202003282108350611', null, '2', '7', '2', 'sys:interfaces', null, '1', null, 'codepen', '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282108350806', '在线聊天管理', '/web/sys/onlineChat', null, null, '202003282108350611', null, '2', '8', '2', 'sys:onlineChat', null, '1', null, 'bank', '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282108350807', '在线用户管理', '/web/sys/onlineUser', null, null, '202003282108350611', null, '2', '9', '2', 'sys:onlineUser', null, '1', null, 'clear', '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282108350808', '数据库表管理', '/web/sys/dbTables', null, null, '202003282108350611', null, '2', '10', '2', 'sys:dbTables', null, '1', null, 'database', '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282108350809', '系统日志管理', '/web/sys/systemLog', null, null, '202003282108350611', null, '2', '11', '2', 'sys:systemLog', null, '1', null, 'experiment', '0', '2020-12-03 09:58:00', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282108350810', '文件管理', '/web/sys/file', null, null, '202003282108350611', null, '2', '12', '2', 'sys:file', null, '1', null, 'file-protect', '0', '2020-12-03 09:58:00', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282108350811', '角色限定管理', '/web/sys/roleRestrict', null, null, '202003282108350611', null, '2', '3', '2', 'sys:roleRestrict', null, '1', null, 'hdd', '0', '2020-12-03 09:58:00', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282108350812', '配置管理', '/web/sys/config', null, null, '202003282108350611', null, '2', '15', '2', 'sys:config', null, '1', null, 'read', '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282108350831', '用户模块分配', '/web/sys/user/userModuleAssignment', '/web/sys/user/userModuleAssignment,/web/sys/user/userModuleInfo/{userId}', 'a2d18c01-d51e-4b2b-ae79-bb6fe7f649f3,d98b5562-23d5-41c9-91f5-eaebb6d067eb', '202003282108350781', null, '3', '7', '3', 'sys:user:module:assignment', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282108350861', '修改模块', '/web/sys/module/modify', '/web/sys/module/modify,/web/sys/module/getModuleIdAndNameList', 'e2e6e6bf-6b35-441b-9fc7-22195abeeec8,ce44967c-da98-4cdb-803a-c4d266e7e3dd', '202003282108350801', null, '3', '5', '3', 'sys:module:modify', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282108350891', '删除角色', null, '/web/sys/role/delete/{roleId}', 'ce0ac3b5-1bd2-4c51-83e6-f51663f8c5c5', '202003282108350791', null, '3', '5', '3', 'sys:role:delete', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282108350931', '查询角色', '/web/sys/role/list', '/web/sys/role/list', '00cee078-d6de-47b2-9e91-049835aa2a02', '202003282108350791', null, '3', '3', '3', 'sys:role:list', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282108350991', '新增用户', '/web/sys/user/add', '/web/sys/user/add,/web/sys/user/portraitUpload/{userId}', '703e6e3d-189f-4d10-93af-7a6b4ef15f3a,0f5a86e6-30ea-4bbe-a4a0-0e061ba6c17a', '202003282108350781', null, '3', '2', '3', 'sys:user:add', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282115442191', '查询模块', '/web/sys/module/list', '/web/sys/module/list', 'd157a220-7e9e-4044-89e1-9b98ec44506e', '202003282108350801', null, '3', '1', '3', 'sys:module:list', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282115442421', '角色详情', '/web/sys/role/detail', '/web/sys/role/detail/{roleId}', '8f24e243-121c-4141-8d32-0f18cd24b925', '202003282108350791', null, '3', '4', '3', 'sys:role:detail', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282115442491', '删除模块', null, '/web/sys/module/delete/{moduleId}', 'd72a6b77-4969-48de-b341-89f8d91fcab3', '202003282108350801', null, '3', '4', '3', 'sys:module:delete', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282115442541', '修改角色', '/web/sys/role/modify', '/web/sys/role/modify,/web/sys/role/detail/{roleId}', 'aeefd02d-9e51-47d8-970b-1ca26b71c351,a48a10c1-0f03-4132-8b66-8ab69a0e72b6', '202003282108350791', null, '3', '2', '3', 'sys:role:modify', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282115442571', '模块详情', '/web/sys/module/detail', '/web/sys/module/detail/{moduleId}', '9d56f92f-b979-4aae-84b0-aa9a6b5d1cc7', '202003282108350801', null, '3', '2', '3', 'sys:module:detail', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282116237201', '新增角色', '/web/sys/role/add', '/web/sys/role/add', '00df5fb1-0a8c-4ed0-bdab-9204b2cf679a', '202003282108350791', null, '3', '1', '3', 'sys:role:add', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282116237411', '用户角色分配', '/web/sys/user/userRoleAssignment', '/web/sys/user/userRoleAssignment/{userId},/web/sys/user/userRoleInfo/{userId}', 'c0bbd0f6-8f1a-4c7e-8880-687f2fb78e54,5e826fe2-4d99-4204-a2de-0aa558bab7fd', '202003282108350781', null, '3', '6', '3', 'sys:user:role:assignment', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282116237491', '修改用户', '/web/sys/user/modify', '/web/sys/user/modify,/web/sys/user/detail/{userId},/web/sys/user/userPortrait', 'dd6d986a-5aba-4fbf-9b90-1475f5417425,2a3a7460-9df2-496d-bf13-1869af11e3cf,31a157e1-ea32-4133-8fd2-aa9ad9bdb6e1', '202003282108350781', null, '3', '3', '3', 'sys:user:modify', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282116593201', '角色模块分配', '/web/sys/role/roleModuleAssignment', '/web/sys/role/roleModuleAssignment/{roleId},/web/sys/role/roleModuleInfo/{roleId}', 'f318a763-3124-46d4-9a6c-e3749ef4c65a,4146d94a-1026-42a4-8be6-1f0db3e1cf6c', '202003282108350791', null, '3', '6', '3', 'sys:role:module:assignment', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282116593381', '删除用户', null, '/web/sys/user/delete/{userId}', 'f2706426-a55e-42f2-b5a6-bea855c3dac2', '202003282108350781', null, '3', '4', '3', 'sys:user:delete', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282116593521', '新增模块', '/web/sys/module/add', '/web/sys/module/add,/web/sys/module/getModuleIdAndNameList/{moduleType}', '877fe3be-253c-4664-b705-97206616bbb9,20320dd5-f597-4b16-b2f7-a9e5e93d2751', '202003282108350801', null, '3', '3', '3', 'sys:module:add', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282117355621', '查询用户', '/web/sys/user/list', '/web/sys/user/list', '43b76c3a-e8da-46a7-bd72-77a14c86ec94', '202003282108350781', null, '3', '1', '3', 'sys:user:list', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282117355941', '用户详情', '/web/sys/user/detail', '/web/sys/user/detail/{userId}', '49f60f3f-10a5-475c-8d4c-3d569c70a3a9', '202003282108350781', null, '3', '5', '3', 'sys:user:detail', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282117355942', '新增字典', '/web/sys/dictionary/add', '/web/sys/dictionary/add', '07695b51-902e-4758-a341-f472fda3e112', '202003282108350802', null, '3', '1', '3', 'sys:dictionary:add', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282117355943', '修改字典', '/web/sys/dictionary/modify', '/web/sys/dictionary/modify,/web/sys/dictionary/detail/{dictionaryId}', '7502b801-655d-4f10-915c-d316f28f70c3,b9188197-7d3c-41dc-90eb-85656967d15c', '202003282108350802', null, '3', '2', '3', 'sys:dictionary:modify', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282117355944', '查询字典', '/web/sys/dictionary/list', '/web/sys/dictionary/list', 'd9e08466-50d2-4b22-976a-81b66dae8431', '202003282108350802', null, '3', '3', '3', 'sys:dictionary:list', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282117355945', '删除字典', null, '/web/sys/dictionary/delete/{dictionaryId}', 'da820d05-c1c4-4aab-ac1e-24748d185c00', '202003282108350802', null, '3', '4', '3', 'sys:dictionary:delete', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282117355946', '字典详情', '/web/sys/dictionary/detail', '/web/sys/dictionary/detail/{dictionaryId}', 'dc3e70b3-5b9b-4227-a99d-1192fc790899', '202003282108350802', null, '3', '5', '3', 'sys:dictionary:detail', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282117355947', '查询操作日志', '/web/sys/operationLog/list', '/web/sys/operationLog/list', '809efb0a-5760-4527-9fb1-31a5e1efee6b', '202003282108350803', null, '3', '1', '3', 'sys:operationLog:list', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282117355948', '查询日程', '/web/sys/schedule/list', '/web/sys/schedule/list', '3fb5ee7f-bc9f-4e17-bde1-7a593f149558', '202003282108350804', null, '3', '1', '3', 'sys:schedule:list', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282117355949', '保存日程', null, '/web/sys/schedule/add', '299091eb-0b73-46cb-b17d-063b7163c5d4', '202003282108350804', null, '3', '2', '3', 'sys:schedule:add', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282117355950', '查询接口', '/web/sys/interfaces/list', '/web/sys/interfaces/list', '607407bd-e5bb-4a0f-a5a9-16b275d21ada', '202003282108350805', null, '3', '1', '3', 'sys:interfaces:list', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282117355951', '接口详情', '/web/sys/interfaces/detail', '/web/sys/interfaces/detail/{interfacesId}', '62c009bc-f945-4be2-b719-4e9f003f8cc5', '202003282108350805', null, '3', '2', '3', 'sys:interfaces:detail', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282117355952', '修改接口', '/web/sys/interfaces/modify', '/web/sys/interfaces/modify,/web/sys/interfaces/detail/{interfacesId}', '0b65ea9a-8384-48c1-9ffa-cee38a3ed287,ab870334-1c0a-4614-9090-4a9b0b066ee1', '202003282108350805', null, '3', '3', '3', 'sys:interfaces:modify', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282117355953', '数据权限分配', '/web/sys/interfaces/dataPermissionAssignment', '/web/sys/interfaces/userRoleDataPermission,/web/sys/interfaces/dataPermissionAssignment/{interfacesId}', 'd0ea3ad2-ba4c-4e7a-83e3-cb4620364cc7,0f8ed70a-4e71-45f6-ac96-3e245e0e1bc4', '202003282108350805', null, '3', '4', '3', 'sys:interfaces:dataPermissionAssignment', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202003282117355954', '在线用户列表', null, '/web/sys/onlineUser/list', '08926768-480a-4d53-9ba9-460787268b46', '202003282108350807', null, '3', '1', '3', 'sys:onlineUser:list', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202004212010126742', '用户下线', null, '/web/sys/onlineUser/offline/{key}', '14048f56-a180-44f7-8c19-26da5edabc91', '202003282108350807', null, '3', '2', '3', 'sys:onlineUser:offline', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202004212010126743', '数据库表列表', '/web/sys/dbTables/list', '/web/sys/dbTables/list', '34f63701-1115-48e5-91b9-c0bd15e01946', '202003282108350808', null, '3', '1', '3', 'sys:dbTables:list', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202004212010126744', '数据库表详情', '/web/sys/dbTables/detail', '/web/sys/dbTables/detail/{tableName}', '3864da55-8ffb-4207-ba03-68cad92637cc', '202003282108350808', null, '3', '2', '3', 'sys:dbTables:detail', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202004212010126745', '数据库表代码生成', null, '/web/sys/dbTables/codeGenerate/{tableName}', 'aeee1202-52e1-4e88-9a78-0c91b9d33b10', '202003282108350808', null, '3', '3', '3', 'sys:dbTables:codeGenerate', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202004212010126746', '数据库表还原', null, '/web/sys/dbTables/reduction', '49fb3df6-f9ad-472f-a6af-88966943e137', '202003282108350808', null, '3', '4', '3', 'sys:dbTables:reduction', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202004212010126747', '数据库操作', '/web/sys/dbTables/operate', '/web/sys/dbTables/operate', '035dea9d-94b6-4e64-b844-ed88f83a9c21', '202003282108350808', null, '3', '5', '3', 'sys:dbTables:operate', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202005161348165371', '初始化密码', null, '/web/sys/user/initPassword/{userId}', '3b9d9802-c538-4cb6-be05-00d1a8714598', '202003282108350781', null, '3', '8', '3', 'sys:user:initPassword', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202005161348165381', '接口测试', '/web/sys/interfaces/test', '/web/sys/interfaces/test', '16d71bb2-d949-45b9-bbd4-ff3deea43f09', '202003282108350805', null, '3', '5', '3', 'sys:interfaces:test', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202005161348165382', '文件列表', '/web/sys/file/list', '/web/sys/file/list', '4de6395d-2367-4475-8107-62ded2e3d00a', '202003282108350810', null, '3', '1', '3', 'sys:file:list', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202005161348165383', '上传文件', null, '/web/sys/file/uploadFile', 'd2ec3c0f-d911-4ab3-9ee9-1d37bb9aa80e', '202003282108350810', null, '3', '2', '3', 'sys:file:uploadFile', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202005161348165384', '下载文件', null, '/web/sys/file/downloadFile', 'fabfbdcd-5441-4ea4-b88c-f62331b5032f', '202003282108350810', null, '3', '3', '3', 'sys:file:downloadFile', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202005161348165385', '文件详情', null, '/web/sys/file/detail/{fileId}', '609e388f-42ef-4f1d-a159-0daad9a38d0f', '202003282108350810', null, '3', '4', '3', 'sys:file:detail', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202005161348165386', '删除文件', null, '/web/sys/file/delete/{fileId}', 'f8bd6c1f-ebbb-4ab1-8f55-ff8b74b9e4ea', '202003282108350810', null, '3', '5', '3', 'sys:file:delete', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202005161348165387', '文件目录列表', '/web/sys/file/list', '/web/sys/file/contentList,/web/sys/file/fileRootPath', 'c66e8a0f-a000-44fe-8fc4-99e09a57d562,2e37b9b2-cca9-463a-b71a-d700eeadd497', '202003282108350810', null, '3', '6', '3', 'sys:file:contentList', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202110221032474732', '新增配置', '/web/sys/config/add', '/web/sys/config/add', '7ece25bd-64b7-482e-82d0-18e93722ffa2', '202003282108350812', null, '3', '1', '3', 'sys:config:add', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202110221032474733', '修改配置', '/web/sys/config/modify', '/web/sys/config/modify,/web/sys/config/detail/{configId}', 'a2f6f7f2-7209-4682-8289-dd9b9e5b8ed1,b66640dc-4167-44fa-beb8-396f24a3599c', '202003282108350812', null, '3', '2', '3', 'sys:config:modify', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202110221032474734', '查询配置', '/web/sys/config/list', '/web/sys/config/list', 'b295d770-2ead-497d-84c9-75d93a8f7c87', '202003282108350812', null, '3', '3', '3', 'sys:config:list', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202110221032474735', '删除配置', null, '/web/sys/config/delete/{configId}', 'd2645a93-c14b-4e58-97c6-3256e5304091', '202003282108350812', null, '3', '4', '3', 'sys:config:delete', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202110221032474736', '配置详情', '/web/sys/config/detail', '/web/sys/config/detail/{configId}', '6643fcfd-67ee-4f7f-b81e-bd8a9335eceb', '202003282108350812', null, '3', '5', '3', 'sys:config:detail', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202111241638095741', '新增角色限定', '/web/sys/roleRestrict/add', '/web/sys/roleRestrict/add,/web/sys/role/listAll', '5600bfdb-1f64-4e7c-9574-81ca2a7601ca', '202003282108350811', null, '3', '1', '3', 'sys:roleRestrict:add', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202111241652226651', '修改角色限定', '/web/sys/roleRestrict/modify', '/web/sys/roleRestrict/modify,/web/sys/roleRestrict/detail/{roleRestrictId},/web/sys/role/listAll', 'd9591160-610a-49fb-8e1b-cafe9bc0000c,55139f19-7438-456f-987d-5aea2eada993,e7d935c2-0294-4c93-8de3-006498d231b6', '202003282108350811', null, '3', '2', '3', 'sys:roleRestrict:modify', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202111241654503461', '查询角色限定', '/web/sys/roleRestrict/list', '/web/sys/roleRestrict/list', '5fd688d3-200b-4363-80d0-ed8cdeb69201', '202003282108350811', null, '3', '3', '3', 'sys:roleRestrict:list', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202111241656483981', '删除角色限定', null, '/web/sys/roleRestrict/delete/{roleRestrictId}', '081253c3-3ed1-4da2-a215-c51d5367c1ef', '202003282108350811', null, '3', '4', '3', 'sys:roleRestrict:delete', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202111241659521211', '角色限定详情', '/web/sys/roleRestrict/detail', '/web/sys/roleRestrict/detail/{roleRestrictId},/web/sys/role/listAll', '4ad76764-e3cc-4c16-8a47-010caecd67d9,733fffae-5589-4cd7-a164-4c09022fcdc9', '202003282108350811', null, '3', '5', '3', 'sys:roleRestrict:detail', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202111241659521212', '获得省信息', null, '/web/sys/roleRestrict/getProvince', 'addddb15-7805-4fca-bd4c-73ad9c58cb38', '202003282108350811', null, '3', '6', '3', 'sys:roleRestrict:province', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202111241659521213', '获得市信息', null, '/web/sys/roleRestrict/getCity/{provinceCode}', '4cc03f4d-c4db-4568-bb0f-d8f3d12d5fcd', '202003282108350811', null, '3', '7', '3', 'sys:roleRestrict:city', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');
INSERT INTO `sys_module` VALUES ('202111241659521214', '获得区信息', null, '/web/sys/roleRestrict/getDistrict/{cityCode}', '1c825651-b881-49a8-8397-753b67e6f738', '202003282108350811', null, '3', '8', '3', 'sys:roleRestrict:district', null, '1', null, null, '0', '2018-02-08 17:02:21', '-1', null, null, '0');

-- ----------------------------
-- Table structure for `sys_operation_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_operation_log`;
CREATE TABLE `sys_operation_log` (
  `id` varchar(255) NOT NULL COMMENT '主键ID',
  `user_id` varchar(255) DEFAULT NULL COMMENT '用户ID',
  `url` varchar(255) DEFAULT NULL COMMENT '请求地址',
  `base_url` varchar(255) DEFAULT NULL COMMENT '基础地址',
  `request_method` varchar(255) DEFAULT NULL COMMENT '请求方法',
  `request_parameter` varchar(20000) DEFAULT NULL COMMENT '请求参数',
  `request_ip_address` varchar(255) DEFAULT NULL COMMENT '请求IP地址',
  `request_time` datetime DEFAULT NULL COMMENT '请求时间',
  `login_way` tinyint(4) DEFAULT NULL COMMENT '登录方式（1：账号密码登录（默认）；2：二维码扫码登录；3：短信验证码登录）',
  `client_type` tinyint(4) DEFAULT NULL COMMENT '客户端类型（1：页面端（默认）；2：安卓端；3：IOS端）',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统操作日志表';

-- ----------------------------
-- Records of sys_operation_log
-- ----------------------------
INSERT INTO `sys_operation_log` VALUES ('202110241051319501', '-1', 'http://localhost:2001/web/sys/user/add', '/web/sys/user/add', 'POST', '{\"email\":\"adsa231\",\"idCard\":\"320503198904030016\",\"password\":\"adsa231\",\"personName\":\"adsa231\",\"phone\":\"13914017164\",\"remark\":\"adsa231\",\"status\":0,\"userName\":\"adsa231\"}', '192.168.1.1', '2021-10-24 10:51:31', '1', '1', null);
INSERT INTO `sys_operation_log` VALUES ('202110241051391581', '-1', 'http://localhost:2001/web/sys/user/modify', '/web/sys/user/modify', 'PUT', '{\"email\":\"adsa231\",\"idCard\":\"320503198904030016\",\"personName\":\"dasdasdasdasd\",\"phone\":\"13914017164\",\"remark\":\"\",\"status\":0,\"userId\":\"202110241051318241\",\"userName\":\"adsa231\"}', '192.168.1.1', '2021-10-24 10:51:39', '1', '1', null);
INSERT INTO `sys_operation_log` VALUES ('202110241051446741', '-1', 'http://localhost:2001/web/sys/user/userRoleAssignment/202110241051318241', '/web/sys/user/userRoleAssignment/{userId}', 'POST', '[{\"dataStrategy\":0,\"moduleStrategy\":0,\"roleId\":\"202109031450187571\"}]', '192.168.1.1', '2021-10-24 10:51:44', '1', '1', null);
INSERT INTO `sys_operation_log` VALUES ('202110241051586031', '-1', 'http://localhost:2001/web/sys/user/initPassword/202110241051318241', '/web/sys/user/initPassword/{userId}', 'GET', null, '192.168.1.1', '2021-10-24 10:51:58', '1', '1', null);

-- ----------------------------
-- Table structure for `sys_province`
-- ----------------------------
DROP TABLE IF EXISTS `sys_province`;
CREATE TABLE `sys_province` (
  `code` varchar(20) NOT NULL COMMENT '省代码',
  `name` varchar(50) NOT NULL COMMENT '省名',
  PRIMARY KEY (`code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='中国省表';

-- ----------------------------
-- Records of sys_province
-- ----------------------------
INSERT INTO `sys_province` VALUES ('1', '北京市');
INSERT INTO `sys_province` VALUES ('2', '天津市');
INSERT INTO `sys_province` VALUES ('3', '河北省');
INSERT INTO `sys_province` VALUES ('4', '山西省');
INSERT INTO `sys_province` VALUES ('5', '内蒙古自治区');
INSERT INTO `sys_province` VALUES ('6', '辽宁省');
INSERT INTO `sys_province` VALUES ('7', '吉林省');
INSERT INTO `sys_province` VALUES ('8', '黑龙江省');
INSERT INTO `sys_province` VALUES ('9', '上海市');
INSERT INTO `sys_province` VALUES ('10', '江苏省');
INSERT INTO `sys_province` VALUES ('11', '浙江省');
INSERT INTO `sys_province` VALUES ('12', '安徽省');
INSERT INTO `sys_province` VALUES ('13', '福建省');
INSERT INTO `sys_province` VALUES ('14', '江西省');
INSERT INTO `sys_province` VALUES ('15', '山东省');
INSERT INTO `sys_province` VALUES ('16', '河南省');
INSERT INTO `sys_province` VALUES ('17', '湖北省');
INSERT INTO `sys_province` VALUES ('18', '湖南省');
INSERT INTO `sys_province` VALUES ('19', '广东省');
INSERT INTO `sys_province` VALUES ('20', '广西壮族自治区');
INSERT INTO `sys_province` VALUES ('21', '海南省');
INSERT INTO `sys_province` VALUES ('22', '重庆市');
INSERT INTO `sys_province` VALUES ('23', '四川省');
INSERT INTO `sys_province` VALUES ('24', '贵州省');
INSERT INTO `sys_province` VALUES ('25', '云南省');
INSERT INTO `sys_province` VALUES ('26', '西藏自治区');
INSERT INTO `sys_province` VALUES ('27', '陕西省');
INSERT INTO `sys_province` VALUES ('28', '甘肃省');
INSERT INTO `sys_province` VALUES ('29', '青海省');
INSERT INTO `sys_province` VALUES ('30', '宁夏回族自治区');
INSERT INTO `sys_province` VALUES ('31', '新疆维吾尔自治区');
INSERT INTO `sys_province` VALUES ('32', '香港特别行政区');
INSERT INTO `sys_province` VALUES ('33', '澳门特别行政区');
INSERT INTO `sys_province` VALUES ('34', '台湾省');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` varchar(255) NOT NULL COMMENT '角色ID',
  `role_name` varchar(255) NOT NULL COMMENT '角色名称',
  `role_code` varchar(255) DEFAULT NULL COMMENT '角色代码',
  `parent_id` varchar(255) DEFAULT NULL COMMENT '角色的上级ID',
  `fcode` varchar(255) DEFAULT NULL COMMENT '层级关系',
  `level` int(11) DEFAULT '0' COMMENT '第几级(0表示未定义层级数;层级数1为最高,即根节点)',
  `type` int(11) DEFAULT '0' COMMENT '类型(0:未定义类型,作为全端通用接口使用;1:PC端;2:安卓端;3:IOS端)',
  `system_id` varchar(255) DEFAULT NULL COMMENT '系统ID',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(255) DEFAULT NULL COMMENT '创建者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新者',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '删除标记(0:未被删除;1:已被删除)',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('202111161557002741', '测试角色A', 'test:role:a', null, null, '0', '0', '1', '这个是测试角色A', '2021-11-16 15:57:57', '-1', null, null, '0');
INSERT INTO `sys_role` VALUES ('202111161557268131', '测试角色B', 'test:role:b', null, null, '0', '0', '1', '这个是测试角色B', '2021-11-16 15:57:46', '-1', '2021-11-16 16:00:08', '-1', '0');
INSERT INTO `sys_role` VALUES ('202111161557555051', '测试角色C', 'test:role:c', null, null, '0', '0', '1', '这个是测试角色C', '2021-11-16 15:57:32', '-1', null, null, '0');

-- ----------------------------
-- Table structure for `sys_role_data`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_data`;
CREATE TABLE `sys_role_data` (
  `id` varchar(255) NOT NULL COMMENT '主键ID',
  `role_id` varchar(255) NOT NULL COMMENT '角色ID',
  `data_permission_id` varchar(255) NOT NULL COMMENT '数据权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色数据表';

-- ----------------------------
-- Records of sys_role_data
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_role_module`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_module`;
CREATE TABLE `sys_role_module` (
  `id` varchar(255) NOT NULL COMMENT '主键ID',
  `role_id` varchar(255) NOT NULL COMMENT '角色ID',
  `module_id` varchar(255) NOT NULL COMMENT '模块ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统角色模块表';

-- ----------------------------
-- Records of sys_role_module
-- ----------------------------
INSERT INTO `sys_role_module` VALUES ('202201031003361781', '202111161557002741', '202003282108350611');
INSERT INTO `sys_role_module` VALUES ('202201031003361801', '202111161557002741', '202003282108350781');
INSERT INTO `sys_role_module` VALUES ('202201031003361821', '202111161557002741', '202003282108350991');

-- ----------------------------
-- Table structure for `sys_role_restrict`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_restrict`;
CREATE TABLE `sys_role_restrict` (
  `id` varchar(255) NOT NULL COMMENT '主键ID',
  `role_id` varchar(255) NOT NULL COMMENT '角色ID',
  `province` varchar(255) DEFAULT NULL COMMENT '省',
  `city` varchar(255) DEFAULT NULL COMMENT '市',
  `district` varchar(255) DEFAULT NULL COMMENT '区',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` int(11) DEFAULT '0' COMMENT '状态（0：正常；1：禁用）',
  `restrict_way` int(11) DEFAULT NULL COMMENT '限定方式（1：本人，本人的话省市区都为null；2：非本人，非本人的话会填充省市区）',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(255) DEFAULT NULL COMMENT '创建者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新者',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '删除标记(0:未被删除;1:已被删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色限定表';

-- ----------------------------
-- Records of sys_role_restrict
-- ----------------------------
INSERT INTO `sys_role_restrict` VALUES ('202111251420529621', '202111161557268131', 'all', 'all', 'all', null, '0', '2', '2021-11-25 14:20:52', '-1', null, null, '0');
INSERT INTO `sys_role_restrict` VALUES ('202111251421135841', '202111161557555051', 'self', 'self', 'self', null, '0', '1', '2021-11-25 14:21:13', '-1', null, null, '0');
INSERT INTO `sys_role_restrict` VALUES ('202201031011397991', '202111161557002741', 'self', 'self', 'self', null, '0', '1', '2022-01-03 10:11:39', '-1', null, null, '0');

-- ----------------------------
-- Table structure for `sys_schedule`
-- ----------------------------
DROP TABLE IF EXISTS `sys_schedule`;
CREATE TABLE `sys_schedule` (
  `id` varchar(255) NOT NULL COMMENT '主键ID',
  `schedule_date` varchar(255) DEFAULT NULL COMMENT '日期',
  `schedule_type` int(11) DEFAULT NULL COMMENT '日程类型（1:周末;2:正常;3:节假日）',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(255) DEFAULT NULL COMMENT '创建者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新者',
  `del_flag` tinyint(4) DEFAULT NULL COMMENT '删除标记(0:未被删除;1:已被删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统日程表';

-- ----------------------------
-- Records of sys_schedule
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` varchar(255) NOT NULL COMMENT '用户ID',
  `user_name` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '用户密码',
  `person_name` varchar(255) DEFAULT NULL COMMENT '用户姓名',
  `id_card` varchar(255) DEFAULT NULL COMMENT '身份证号码',
  `email` varchar(255) DEFAULT NULL COMMENT '电子邮箱',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号码',
  `portrait` varchar(255) DEFAULT NULL COMMENT '头像',
  `parent_id` varchar(255) DEFAULT NULL COMMENT '创建该用户的ID',
  `fcode` varchar(255) DEFAULT NULL COMMENT '层级关系',
  `level` int(11) DEFAULT '0' COMMENT '第几级（层级数0为最高，即根节点）',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` int(11) DEFAULT '0' COMMENT '账号状态（0：正常；1：禁用）',
  `real_name_status` int(11) DEFAULT '0' COMMENT '实名认证状态（0：未实名认证；1：已实名认证）',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `province` varchar(255) DEFAULT NULL COMMENT '省',
  `city` varchar(255) DEFAULT NULL COMMENT '市',
  `district` varchar(255) DEFAULT NULL COMMENT '区',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(255) DEFAULT NULL COMMENT '创建者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `updater` varchar(255) DEFAULT NULL COMMENT '更新者',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '删除标记(0:未被删除;1:已被删除)',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('-1', 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '管理员', null, null, null, null, null, null, '0', '管理员，该账号无法被删除，即使删除也会被恢复', '0', '0', null, null, null, null, '2021-03-03 14:01:53', '-1', '2021-03-03 14:01:57', '-1', '0');
INSERT INTO `sys_user` VALUES ('202109031448285771', 'abcd1234', 'e9cee71ab932fde863338d08be4de9dfe39ea049bdafb342ce659ec5450b69ae', 'abcd1234', '111111111111111111', 'abcd1234@test.com', '11111111111', null, '-1', null, '1', '只是备注', '0', '0', null, '10', '78', '778', '2021-09-03 14:48:28', '-1', '2022-01-03 09:14:19', '-1', '0');

-- ----------------------------
-- Table structure for `sys_user_data`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_data`;
CREATE TABLE `sys_user_data` (
  `id` varchar(255) NOT NULL COMMENT '主键ID',
  `user_id` varchar(255) NOT NULL COMMENT '用户ID',
  `data_permission_id` varchar(255) NOT NULL COMMENT '数据权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户数据表';

-- ----------------------------
-- Records of sys_user_data
-- ----------------------------
INSERT INTO `sys_user_data` VALUES ('202201031117498871', '202109031448285771', '202201031117498851');

-- ----------------------------
-- Table structure for `sys_user_module`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_module`;
CREATE TABLE `sys_user_module` (
  `id` varchar(255) NOT NULL COMMENT '主键ID',
  `user_id` varchar(255) NOT NULL COMMENT '用户ID',
  `module_id` varchar(255) NOT NULL COMMENT '模块ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统用户模块表';

-- ----------------------------
-- Records of sys_user_module
-- ----------------------------
INSERT INTO `sys_user_module` VALUES ('202201031001570291', '202109031448285771', '202003282108350611');
INSERT INTO `sys_user_module` VALUES ('202201031001570301', '202109031448285771', '202003282108350781');
INSERT INTO `sys_user_module` VALUES ('202201031001570321', '202109031448285771', '202003282117355621');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` varchar(255) NOT NULL COMMENT '主键ID',
  `user_id` varchar(255) NOT NULL COMMENT '用户ID',
  `role_id` varchar(255) NOT NULL COMMENT '角色ID',
  `module_strategy` int(11) DEFAULT NULL COMMENT '权限获取策略(0:自定义;1:并集;2:交集;3:以用户权限为准;4:以角色权限为准;其它:默认为未定义,作为并集处理)',
  `data_strategy` int(11) DEFAULT NULL COMMENT '数据获取策略(0:自定义;1:并集;2:交集;3:以用户权限为准;4:以角色权限为准;其它:默认为未定义,作为并集处理)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统用户角色表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('202201031001218531', '202109031448285771', '202111161557002741', '1', '1');
