$(function() {

    Morris.Area({
        element: 'morris-area-chart',
        data: [{
            period: '2015 Q1',
            isam: 2,
            fttu: null
        }, {
            period: '2015 Q2',
            isam: 4,
            fttu: 2
        }, {
            period: '2015 Q3',
            isam: 4,
            fttu: 1
        }, {
            period: '2015 Q4',
            isam: 5,
            fttu: 3
        }, {
            period: '2016 Q1',
            isam: 6,
            fttu: 1
        }, {
            period: '2016 Q2',
            isam: 7,
            fttu: 4
        }, {
            period: '2016 Q3',
            isam: 7,
            fttu: 3
        }, {
            period: '2016 Q4',
            isam: 9,
            fttu: 5
        }, {
            period: '2017 Q1',
            isam: 8,
            fttu: 7
        }, {
            period: '2017 Q2',
            isam: 8,
            fttu: 6
        }],
        xkey: 'period',
        ykeys: ['isam', 'fttu'],
        labels: ['isam', 'fttu'],
        pointSize: 1,
        hideHover: 'auto',
        resize: true
    });

//    Morris.Donut({
//        element: 'morris-donut-chart',
//        data: [{
//            label: "Download Sales",
//            value: 12
//        }, {
//            label: "In-Store Sales",
//            value: 30
//        }, {
//            label: "Mail-Order Sales",
//            value: 20
//        }],
//        resize: true
//    });

    Morris.Bar({
        element: 'morris-bar-chart',
        data: [{
            y: '2011',
            a: 10,
            b: 9
        }, {
            y: '2012',
            a: 15,
            b: 25
        }, {
            y: '2013',
            a: 15,
            b: 14
        }, {
            y: '2014',
            a: 25,
            b: 15
        }, {
            y: '2015',
            a: 33,
            b: 28
        }, {
            y: '2016',
            a: 18,
            b: 22
        }, {
            y: '2017',
            a: 10,
            b: 29
        }],
        xkey: 'y',
        ykeys: ['a', 'b'],
        labels: ['FTTU', 'ISAM'],
        hideHover: 'auto',
        resize: true
    });

});
