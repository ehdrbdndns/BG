$(function() {
  'use strict';

  if($('#chartArea').length) {
    new Chart($('#chartArea'), {
      type: 'line',
      data: {
        labels: ['12월','1월','2월','4월','5월','6월','7월','8월','9월','10월'],
        datasets: [{
          data: [86,114,106,106,107,111,133,221,783,2478],
          label: "경기도",
          borderColor: "#7ee5e5",
          backgroundColor: "#c2fdfd",
          fill: true
        }, {
          data: [282,350,411,502,635,809,947,1402,3700,5267],
          label: "용인시",
          borderColor: "#f77eb9",
          backgroundColor: "#ffbedd",
          fill: true
        }
        ]
      }
    });
  }

});