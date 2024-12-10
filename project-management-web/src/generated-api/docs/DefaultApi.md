# ProjectApi.DefaultApi

All URIs are relative to *http://localhost:7070*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createProject**](DefaultApi.md#createProject) | **POST** /project | 
[**findProjects**](DefaultApi.md#findProjects) | **GET** /project/list | 
[**getById**](DefaultApi.md#getById) | **GET** /project/{projectId} | 



## createProject

> String createProject(opts)



### Example

```javascript
import ProjectApi from 'project_api';

let apiInstance = new ProjectApi.DefaultApi();
let opts = {
  'project': new ProjectApi.Project() // Project | 
};
apiInstance.createProject(opts, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project** | [**Project**](Project.md)|  | [optional] 

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: text/plain


## findProjects

> [Project] findProjects()



### Example

```javascript
import ProjectApi from 'project_api';

let apiInstance = new ProjectApi.DefaultApi();
apiInstance.findProjects((error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**[Project]**](Project.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getById

> Project getById(projectId)



### Example

```javascript
import ProjectApi from 'project_api';

let apiInstance = new ProjectApi.DefaultApi();
let projectId = 3.4; // Number | 
apiInstance.getById(projectId, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **Number**|  | 

### Return type

[**Project**](Project.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: aplication/json

