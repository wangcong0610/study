#!/usr/bin/python3
# -*- coding: UTF-8 -*-

import sys
from optparse import OptionParser

version = "0.0.1"
project_name = ""
module_name = ""
branch_name = "master"
# 默认的tomcat home
default_tomcat_path = "/home/work/bin/"
# tomcat 文件名
default_tomcat_file_name = "apache-tomcat-8.5.16.tar.gz"
# tomcat 下载路径
default_tomcat_download_path = "http://apache.fayea.com/tomcat/tomcat-8/v8.5.16/bin/apache-tomcat-8.5.16.tar.gz"
# 项目源码路径
default_project_source_path = "/home/work/source/"
# 应用目录前缀
default_app_home_prefix = "tomcat-8-"
# 应用gitlab host
gitlab_host = "ssh://git@219.244.186.30:8610/"
# 应用gitlab group
gitlab_group = "platform/"
# 应用gitlab url 后缀
gitlab_project_suffix = ".git"

parser = OptionParser(
    version="platforms system deploy script.\nversion:{}.\ndeveloper:zp.\nphone:15877326537.".format(version))
parser.add_option("-p", "--project", dest="project", help="what project you want deploy?")
parser.add_option("-m", "--module", dest="module", help="what module you want deploy?")
parser.add_option("-b", "--branch", dest="branch", help="what branch you want deploy?")


def get_gitlab_url(project_name):
    global gitlab_host
    global gitlab_group
    global gitlab_project_suffix
    url = gitlab_host + gitlab_group + project_name + "/" + gitlab_project_suffix
    return url


def show_version():
    print("\nplatform deploy scrip.\nversion:0.0.1.\ndeveloper:zp.\nphone:15877326537.".format(version))


def main():
    try:
        # opts, args = getopt.getopt(sys.argv[1:], "h?vp:m:b:", ["help", "version", "project=", "module=", "branch="])
        (options, args) = parser.parse_args()
    except Exception as e:
        sys.exit()

    global project_name
    global module_name
    global branch_name
    global default_tomcat_path
    global default_tomcat_download_path
    global default_project_source_path
    global default_app_home_prefix

    # 判断参数：启动、重启、停止

    if options.project:
        project_name = options.project
    if options.module:
        module_name = options.module
    if options.branch:
        branch_name = options.branch

    print(project_name + module_name + branch_name)

    if project_name.__len__() <= 0:
        print("Project name is required parameter. Please see help.")
        sys.exit()
    if module_name.__len__() <= 0:
        print("Module name is required parameter. Please see help.")
        sys.exit()
    if branch_name.__len__() <= 0:
        print("Branch name is required parameter. Please see help.")
        sys.exit()

    # 判断代码是否存在
        #没有则拉取
        #有则拉取最新版本
    # 判断是否部署过项目
        #如果没有
        # 判断tomcat文件是否存在
            #没有则下载
        # 解压tomcat文件到指定路径
        # 修改端口
    # 编译指定module
    # 停止tomcat
    # 删除原war包
    # 复制新文件
    # 启动tomcat
    print(get_gitlab_url(project_name))


if __name__ == "__main__":
    main()
