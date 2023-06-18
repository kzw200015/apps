port: 7890
socks-port: 7891
allow-lan: true
mode: rule
log-level: info
external-controller: :9090
proxy-providers:
  跑路云:
    type: http
    url: ${url}
    interval: 86400
    path: ./proxy-providers/跑路云.yaml
proxy-groups:
  - name: 节点选择
    type: select
    filter: ${filter}
    use:
      - 跑路云
  - name: 漏网之鱼
    type: select
    proxies:
      - 节点选择
      - 全球直连
  - name: 全球直连
    type: select
    proxies:
      - DIRECT
  - name: 全球拦截
    type: select
    proxies:
      - REJECT
rules:
  - RULE-SET,LocalAreaNetwork,全球直连
  - DOMAIN-SUFFIX,skytech.io,全球直连
  - DOMAIN-SUFFIX,steamcommunity.com,节点选择
  - RULE-SET,Steam,全球直连
  - RULE-SET,Apple,全球直连
  - RULE-SET,ProxyLite,节点选择
  - GEOIP,CN,全球直连
  - MATCH,漏网之鱼
rule-providers:
  LocalAreaNetwork:
    type: http
    behavior: classical
    url: https://raw.githubusercontent.com/ACL4SSR/ACL4SSR/master/Clash/Providers/LocalAreaNetwork.yaml
    path: ./rule-providers/LocalAreaNetwork.yaml
    interval: 86400
  Steam:
    type: http
    behavior: classical
    url: https://raw.githubusercontent.com/ACL4SSR/ACL4SSR/master/Clash/Providers/Ruleset/Steam.yaml
    path: ./rule-providers/Steam.yaml
    interval: 86400
  Apple:
    type: http
    behavior: classical
    url: https://raw.githubusercontent.com/ACL4SSR/ACL4SSR/master/Clash/Providers/Ruleset/Apple.yaml
    path: ./rule-providers/Apple.yaml
    interval: 86400
  ProxyLite:
    type: http
    behavior: classical
    url: https://raw.githubusercontent.com/ACL4SSR/ACL4SSR/master/Clash/Providers/ProxyLite.yaml
    path: ./rule-providers/ProxyLite.yaml
    interval: 86400