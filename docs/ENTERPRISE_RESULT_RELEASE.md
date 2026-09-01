# 企业级检验结果发布治理

`POST /api/enterprise/lis/lab-result-release` 检查患者与标本身份、流转链、分析仪质控、校准、单位参考区间、历史差异、危急值通知、专科复核和更正审计，返回 `RELEASE / REVIEW / BLOCKED`。

生产环境应对接分析仪、检验质控、危急值通信和 EMR，并保证结果更正不会覆盖原始版本。
