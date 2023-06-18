port: 7890
socks-port: 7891
allow-lan: true
mode: rule
log-level: info
external-controller: :9090

dns:
  default-nameserver:
    - 223.5.5.5
    - 114.114.114.114
  nameserver:
    - https://doh.pub/dns-query
    - https://dns.alidns.com/dns-query

proxy-providers:
  ${name}:
    type: http
    url: <#noautoesc>${url}</#noautoesc>
    interval: 86400
    path: ./proxy-providers/${name}.yaml

proxy-groups:
  - name: 节点选择
    type: select
    filter: <#noautoesc>${filter}</#noautoesc>
    use:
      - ${name}
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
