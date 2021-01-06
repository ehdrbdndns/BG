$(function() {
  'use strict';

  if($('#chartCategory').length) {
    new Chart($('#chartCategory'), {
      type: 'doughnut',
      data: {
        labels: ["카테고리1", "카테고리2", "카테고리3"],
        datasets: [
          {
            label: "Population (millions)",
            backgroundColor: ["#7ee5e5","#f77eb9","#4d8af0"],
            data: [2478,4267,1334]
          }
        ]
      }
    });
  }

  if($('#chartAdvertise').length) {
    new Chart($('#chartAdvertise'), {
      type: 'doughnut',
      data: {
        labels: ["광고1", "광고2", "광고3"],
        datasets: [
          {
            label: "Population (millions)",
            backgroundColor: ["#7ee5e5","#f77eb9","#4d8af0"],
            data: [2478,4267,1334]
          }
        ]
      }
    });
  }

  if($('#chartProposal').length) {
    new Chart($("#chartProposal"), {
      type: 'bar',
      data: {
        labels: [ "바꿔머거", "시켜먹어"],
        datasets: [
          {
            label: "Population",
            backgroundColor: ["#b1cfec","#f77eb9","#f77eb9"],
            data: [1500, 2000, 0]
          }
        ]
      },
      options: {
        legend: { display: false },
      }
    });
  }

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