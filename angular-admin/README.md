# Angular V1.0          
# 一、项目重要说明          
1、angular版本为：13.2.2    
2、关于package.json    
dependencies的较小基础依赖为：@angular/animations、@angular/common、@angular/compiler、@angular/core、@angular/forms、@angular/platform-browser、@angular/platform-browser-dynamic、@angular/router、rxjs    
devDependencies的较小基础依赖为：@angular-devkit/build-angular、@angular/cli、@angular/compiler-cli、@types/jasmine、@types/jasminewd2、@types/node、jasmine-core、jasmine-spec-reporter、karma、karma-chrome-launcher、karma-coverage-istanbul-reporter、karma-jasmine、karma-jasmine-html-reporter、typescript、codelyzer    
3、http响应未做全局拦截处理，有需要请自行优化    
4、UI目前Bootstrap和PrimeNG结合使用中，未来考虑全部使用PrimeNG    
# 二、运行和打包          
1、建议删除原来的node_modules（如果有）    
2、安装：npm install    
3、运行：npm start    
4、打包：npm run build    
5、访问：http://localhost:4200    
# 三、npm相关配置说明          
1、下载最新版的node.js（https://nodejs.org/zh-cn），配置环境变量    
2、命令行输入：npm config get prefix获得路径，如：C:\Users\admin\AppData\Roaming    
3、进入根据步骤2获得的路径，删除npm和npm-cache文件夹，然后npm cache clean --force    
4、下载最新版本的npm：npm -g install npm（国内快点的话可以使用[npm install -g cnpm --registry=https://registry.npm.taobao.org]以后命令就由npm变为cnpm）    
5、下载最新版的typescript：npm -g install typescript（查看typescript的版本：tsc -v）    
6、下载最新版的Angular CLI（可跳过）：npm -g install @angular/cli，查看版本：ng --version    
7、下载最新版的gulp（可跳过）：npm -g install gulp    
8、下载最新版的yarn（可跳过）：npm -g install yarn    
9、下载最新版的bower（可跳过）：npm -g install bower    
10、下载最新版的WebStorm或VisualStudioCode（可跳过）    
11、测试（可跳过）：新建文件test.ts写一些typescript代码，然后运行tsc test.ts将其编译成test.js，然后在html中正常引入使用    
注：删除npm包：npm uninstall -g xxx    
# 四、其它          
1、angular参考：https://angular.io/api    
2、bootstrap参考：https://getbootstrap.com/docs/4.6/getting-started/introduction    
3、angular最小依赖参考：https://angular.io/guide/npm-packages    
4、npm参考：https://www.npmjs.com    
5、npm命令行cmd代理设置    
set http_proxy=http://255.255.255.255:80    
set https_proxy=http://255.255.255.255:80    
npm cache clear --force    
删除package-lock.json    
npm install           
# 五、常见错误及解决          
1、ERROR in The Angular Compiler requires TypeScript >=3.9.2 and <4.1.0 but 4.1.3 was found instead    
解决：npm install typescript@">=3.9.2 < 4.1.0"    
