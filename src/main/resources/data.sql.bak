/*
Navicat PGSQL Data Transfer

Source Server         : Docker-postgres
Source Server Version : 90604
Source Host           : 192.168.58.139:5432
Source Database       : postgres
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90604
File Encoding         : 65001

Date: 2017-10-22 16:57:11
*/


-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_role";
CREATE TABLE "public"."sys_role" (
"id" varchar(50) COLLATE "default" NOT NULL,
"name" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO "public"."sys_role" VALUES ('14d0a56b291e4a308e878e014cdd7304', 'ROLE_USER');
INSERT INTO "public"."sys_role" VALUES ('9a6adfb1b0c54493bfa98fce4a92bdf5', 'ROLE_ADMIN');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_user";
CREATE TABLE "public"."sys_user" (
"id" varchar(50) COLLATE "default" NOT NULL,
"username" varchar(255) COLLATE "default",
"password" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO "public"."sys_user" VALUES ('07504048c5e74aa791154c706b2e785d', 'demo', '$2a$10$9TC3D3zIFaviUWixjcNfBu2qQkDmxO51.y/PYkKOrAVwhVIq4RKGC');
INSERT INTO "public"."sys_user" VALUES ('0d896a1a25e44feeb41e499360ef4d99', 'admin', '$2a$10$rmwdjsDhq.Ib3FupkLv3SeRofIQD8Do94UIGTFGBN6ki7EWQaG8hO');
INSERT INTO "public"."sys_user" VALUES ('21021066bc6f4f2aad58dc5dcb3e2585', 'feifei.liu@pcstars.com', '$2a$10$YKJVDvvVUR5ej4vcttyWEuMX86iEfEBeEdmVauLkrx9n9GuINbVqa');

-- ----------------------------
-- Table structure for sys_user_roles
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_user_roles";
CREATE TABLE "public"."sys_user_roles" (
"sys_user_id" varchar(50) COLLATE "default" NOT NULL,
"roles_id" varchar(50) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_user_roles
-- ----------------------------
INSERT INTO "public"."sys_user_roles" VALUES ('07504048c5e74aa791154c706b2e785d', '14d0a56b291e4a308e878e014cdd7304');
INSERT INTO "public"."sys_user_roles" VALUES ('0d896a1a25e44feeb41e499360ef4d99', '9a6adfb1b0c54493bfa98fce4a92bdf5');
INSERT INTO "public"."sys_user_roles" VALUES ('21021066bc6f4f2aad58dc5dcb3e2585', '9a6adfb1b0c54493bfa98fce4a92bdf5');

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table sys_role
-- ----------------------------
ALTER TABLE "public"."sys_role" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_user
-- ----------------------------
ALTER TABLE "public"."sys_user" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_user_roles
-- ----------------------------
ALTER TABLE "public"."sys_user_roles" ADD PRIMARY KEY ("sys_user_id", "roles_id");
