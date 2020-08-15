### 基于SpringCloud Alibaba的微服务基础架构
目前的实现有：
1. 通用基础配置的搭建，包括数据库模块、日志模块、mybatis配置、swagger文档配置
2. 权限控制中心auth的基本实现，基于SpringSecurity + OAuth 2.0，具体配置还有待完善

计划：
1. 基于SpringCloud Gateway实现网关功能，包括负载均衡、限流降级、自动熔断等
2. 数据库连接池Druid实现
3. 监控服务
