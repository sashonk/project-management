/**
 * Project API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 *
 */

(function(root, factory) {
  if (typeof define === 'function' && define.amd) {
    // AMD.
    define(['expect.js', process.cwd()+'/src/index'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    factory(require('expect.js'), require(process.cwd()+'/src/index'));
  } else {
    // Browser globals (root is window)
    factory(root.expect, root.ProjectApi);
  }
}(this, function(expect, ProjectApi) {
  'use strict';

  var instance;

  beforeEach(function() {
    instance = new ProjectApi.Project();
  });

  var getProperty = function(object, getter, property) {
    // Use getter method if present; otherwise, get the property directly.
    if (typeof object[getter] === 'function')
      return object[getter]();
    else
      return object[property];
  }

  var setProperty = function(object, setter, property, value) {
    // Use setter method if present; otherwise, set the property directly.
    if (typeof object[setter] === 'function')
      object[setter](value);
    else
      object[property] = value;
  }

  describe('Project', function() {
    it('should create an instance of Project', function() {
      // uncomment below and update the code to test Project
      //var instance = new ProjectApi.Project();
      //expect(instance).to.be.a(ProjectApi.Project);
    });

    it('should have the property id (base name: "id")', function() {
      // uncomment below and update the code to test the property id
      //var instance = new ProjectApi.Project();
      //expect(instance).to.be();
    });

    it('should have the property title (base name: "title")', function() {
      // uncomment below and update the code to test the property title
      //var instance = new ProjectApi.Project();
      //expect(instance).to.be();
    });

    it('should have the property dateStarted (base name: "dateStarted")', function() {
      // uncomment below and update the code to test the property dateStarted
      //var instance = new ProjectApi.Project();
      //expect(instance).to.be();
    });

    it('should have the property dueDate (base name: "dueDate")', function() {
      // uncomment below and update the code to test the property dueDate
      //var instance = new ProjectApi.Project();
      //expect(instance).to.be();
    });

    it('should have the property dateCompleted (base name: "dateCompleted")', function() {
      // uncomment below and update the code to test the property dateCompleted
      //var instance = new ProjectApi.Project();
      //expect(instance).to.be();
    });

    it('should have the property goals (base name: "goals")', function() {
      // uncomment below and update the code to test the property goals
      //var instance = new ProjectApi.Project();
      //expect(instance).to.be();
    });

    it('should have the property progress (base name: "progress")', function() {
      // uncomment below and update the code to test the property progress
      //var instance = new ProjectApi.Project();
      //expect(instance).to.be();
    });

    it('should have the property status (base name: "status")', function() {
      // uncomment below and update the code to test the property status
      //var instance = new ProjectApi.Project();
      //expect(instance).to.be();
    });

    it('should have the property members (base name: "members")', function() {
      // uncomment below and update the code to test the property members
      //var instance = new ProjectApi.Project();
      //expect(instance).to.be();
    });

  });

}));
