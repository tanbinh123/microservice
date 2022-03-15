import { Component, OnInit } from '@angular/core';

import * as echarts from 'echarts';

@Component({
  selector: 'app-web-home-centeral',
  templateUrl: './centeral.html',
  styleUrls: ['./centeral.scss']
})

export class CenteralComponent implements OnInit {

  constructor() {

  }

  ngOnInit() {
    this.chart1();
    this.chart2();
    this.chart3();
    this.chart4();
  }

  public chart1():void {
    const lineChart = echarts.init(document.getElementById('chart1'));
    const lineChartOption = {
      title: {
          text: '饼图',
          left: 'left'
      },
      tooltip: {
          trigger: 'item'
      },
      series: [
          {
              name: '用户数量',
              type: 'pie',
              radius: '50%',
              data: [
                  {value: 12698240, name: '游客'},
                  {value: 9997521, name: '注册用户'},
                  {value: 7254245, name: 'VIP1用户'},
                  {value: 5800233, name: 'VIP2用户'},
                  {value: 3502211, name: 'VIP3用户'}
              ],
              emphasis: {
                  itemStyle: {
                      shadowBlur: 10,
                      shadowOffsetX: 0,
                      shadowColor: 'rgba(0, 0, 0, 0.5)'
                  }
              }
          }
      ]
    };
    lineChart.setOption(lineChartOption);
  }

  public chart2():void {
    const lineChart = echarts.init(document.getElementById('chart2'));
    const lineChartOption = {
      title: {
        text: '柱状图'
      },
      tooltip: {
          trigger: 'axis',
          axisPointer: {
              type: 'cross',
              crossStyle: {
                  color: '#999'
              }
          }
      },
      legend: {
          data: ['蒸发量', '降水量', '平均温度']
      },
      xAxis: [
          {
              type: 'category',
              data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
              axisPointer: {
                  type: 'shadow'
              }
          }
      ],
      yAxis: [
          {
              type: 'value',
              name: '水量',
              min: 0,
              max: 250,
              interval: 50,
              axisLabel: {
                  formatter: '{value} ml'
              }
          },
          {
              type: 'value',
              name: '温度',
              min: 0,
              max: 25,
              interval: 5,
              axisLabel: {
                  formatter: '{value} °C'
              }
          }
      ],
      series: [
          {
              name: '蒸发量',
              type: 'bar',
              data: [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
          },
          {
              name: '降水量',
              type: 'bar',
              data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
          },
          {
              name: '平均温度',
              type: 'line',
              yAxisIndex: 1,
              data: [2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2]
          }
      ]
    };
    lineChart.setOption(lineChartOption);
  }

  public chart3():void {
    const lineChart = echarts.init(document.getElementById('chart3'));
    const lineChartOption = {
      title: {
        text: '散点图'
      },
      xAxis: {},
      yAxis: {},
      series: [{
          symbolSize: 20,
          data: [
              [10.01, 48.04],
              [28.07, 36.95],
              [33.02, 27.58],
              [49.05, 18.81],
              [51.11, 98.33],
              [64.35, 87.66],
              [73.41, 76.81],
              [80.29, 66.33],
              [94.88, 58.96],
              [12.51, 46.82],
              [29.15, 37.22],
              [31.15, 27.24],
              [41.03, 14.23],
              [52.21, 97.83],
              [61.02, 84.47],
              [71.05, 73.33],
              [84.05, 64.96],
              [96.03, 57.24],
              [12.02, 46.26],
              [22.03, 38.84],
              [37.08, 25.82],
              [45.02, 15.68]
          ],
          type: 'scatter'
      }]
    };
    lineChart.setOption(lineChartOption);
  }

  public chart4():void {
    const lineChart = echarts.init(document.getElementById('chart4'));
    const lineChartOption = {
      color: ['#80FFA5', '#00DDFF', '#37A2FF', '#FF0087', '#FFBF00'],
      title: {
          text: '折线图'
      },
      tooltip: {
          trigger: 'axis',
          axisPointer: {
              type: 'cross',
              label: {
                  backgroundColor: '#6a7985'
              }
          }
      },
      legend: {
          data: ['方式1', '方式2', '方式3', '方式4', '方式5']
      },
      grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
      },
      xAxis: [
          {
              type: 'category',
              boundaryGap: false,
              data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
          }
      ],
      yAxis: [
          {
              type: 'value'
          }
      ],
      series: [
          {
              name: '方式1',
              type: 'line',
              stack: '总量',
              smooth: true,
              lineStyle: {
                  width: 0
              },
              showSymbol: false,
              areaStyle: {
                  opacity: 0.8,
                  color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                      offset: 0,
                      color: 'rgba(128, 255, 165)'
                  }, {
                      offset: 1,
                      color: 'rgba(1, 191, 236)'
                  }])
              },
              emphasis: {
                  focus: 'series'
              },
              data: [140, 232, 101, 264, 90, 340, 250]
          },
          {
              name: '方式2',
              type: 'line',
              stack: '总量',
              smooth: true,
              lineStyle: {
                  width: 0
              },
              showSymbol: false,
              areaStyle: {
                  opacity: 0.8,
                  color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                      offset: 0,
                      color: 'rgba(0, 221, 255)'
                  }, {
                      offset: 1,
                      color: 'rgba(77, 119, 255)'
                  }])
              },
              emphasis: {
                  focus: 'series'
              },
              data: [120, 282, 111, 234, 220, 340, 310]
          },
          {
              name: '方式3',
              type: 'line',
              stack: '总量',
              smooth: true,
              lineStyle: {
                  width: 0
              },
              showSymbol: false,
              areaStyle: {
                  opacity: 0.8,
                  color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                      offset: 0,
                      color: 'rgba(55, 162, 255)'
                  }, {
                      offset: 1,
                      color: 'rgba(116, 21, 219)'
                  }])
              },
              emphasis: {
                  focus: 'series'
              },
              data: [320, 132, 201, 334, 190, 130, 220]
          },
          {
              name: '方式4',
              type: 'line',
              stack: '总量',
              smooth: true,
              lineStyle: {
                  width: 0
              },
              showSymbol: false,
              areaStyle: {
                  opacity: 0.8,
                  color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                      offset: 0,
                      color: 'rgba(255, 0, 135)'
                  }, {
                      offset: 1,
                      color: 'rgba(135, 0, 157)'
                  }])
              },
              emphasis: {
                  focus: 'series'
              },
              data: [220, 402, 231, 134, 190, 230, 120]
          },
          {
              name: '方式5',
              type: 'line',
              stack: '总量',
              smooth: true,
              lineStyle: {
                  width: 0
              },
              showSymbol: false,
              label: {
                  show: true,
                  position: 'top'
              },
              areaStyle: {
                  opacity: 0.8,
                  color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                      offset: 0,
                      color: 'rgba(255, 191, 0)'
                  }, {
                      offset: 1,
                      color: 'rgba(224, 62, 76)'
                  }])
              },
              emphasis: {
                  focus: 'series'
              },
              data: [220, 302, 181, 234, 210, 290, 150]
          }
      ]
    };
    lineChart.setOption(lineChartOption);
  }

}
