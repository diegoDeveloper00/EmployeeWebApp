app.factory('myHttpInterceptor', function($q, $location, $localStorage) {
	// alternatively, register the interceptor via an anonymous factory
	$httpProvider.interceptors.push(function ($q, $location, $localStorage) {
	return {
	'response': function (config) {
	        config.headers = config.headers || {};
	    if ($localStorage.token) {
	            config.headers.Authorization = 'Bearer ' + $localStorage.token;
	        }
	        return config;
	    },
	    'responseError': function (response) {
	        if (response.status === 401 || response.status === 403) {
	            $location.path('/login.html');
	        }
	        return $q.reject(response);
	    }
	};
	});
});