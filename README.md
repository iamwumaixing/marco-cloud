# Introduce

基于 SpringCloud 体系的快速脚手架，为应用快速开发提供帮助与参考。

## Quick Start

### 安装环境
* Git
* JDK：本项目基于 JDK1.8 向上兼容，请使用 JDK 的版本大于 1.8
* Maven：版本无限制，国内环境建议更换源

### 获取项目并启动
1. 克隆本仓库：`git clone https://github.com/iamwumaixing/marco-cloud.git`
2. 相应的需要先搭建 MySQL、Redis、Nacos Server 等基础服务
3. 对每个启动服务的 `bootstrap.yaml` 进行配置，其他参数可根据实际自行配置
4. 启动项目

## 需求列表
### 已实现
#### 服务列表

| 模块名           | 依赖                    | 端口号  | 服务   |
|---------------|------------------------|------|------|
| cloud-gateway | SpringCloud Gateway    | 9999 | 网关服务 |
| cloud-auth    | OAuth2、Spring Security | 9901 | 授权服务 |
| user-service  | springboot web         | 9900 | 用户服务 |

#### 基础模块

| 模块名                     | 依赖                       | 类别     |
|-------------------------|--------------------------|--------|
| cloud-common-core       | hutool、redis             | 基础核心代码 |
| cloud-common-datasource | mybatis-plus             | 多数据源   |
| cloud-common-entity     | /                        | 公共实体类  |
| cloud-common-log        | /                        | 日志     |
| cloud-common-mybatis    | mybatis-plus、mysql、druid | 数据库依赖  |
| cloud-common-swagger    | swagger                  | api文档  |

### 待实现
待补充...

