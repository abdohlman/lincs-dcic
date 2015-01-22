var mod = angular.module("carouselMod", []);

mod.controller("carouselCtrl", ["$scope", function($scope) {
    $scope.slides = [
        {
            index: 0,
            image: 'http://placehold.it/1140x340',
            //image: '/images/carousel/request-for-applications.png',
            title: 'Request for Applications',
            caption: 'Data science research collaborations with the DCIC that focus on mining and integrating data generated by the LINCS program.',
            link: '#/edsr',
            target: '_blank'
        },
        {
            index: 1,
            image: 'http://placehold.it/1140x340',
            //image: '/images/carousel/summer-research.png',
            title: 'Summer Research Program',
            caption: 'Currently accepting applications for our ten-week summer research training program in biomedical big data science!',
            link: '#/srp',
            target: '_self'
        },
        {
            index: 2,
            image: 'http://placehold.it/1140x340',
            //image: '/images/carousel/big-data.png',
            title: 'Big Data Science',
            caption: 'Learn various methods of analysis of LINCS data and other relevant Big Data with the DCIC\'s MOOC on Coursera.',
            link: 'https://www.coursera.org/course/bd2klincs',
            target: '_blank'
        }
    ];
}]);
