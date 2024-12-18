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

import ApiClient from '../ApiClient';
import ProjectMember from './ProjectMember';
import ProjectStatus from './ProjectStatus';

/**
 * The Project model module.
 * @module model/Project
 * @version 1.0.0
 */
class Project {
    /**
     * Constructs a new <code>Project</code>.
     * @alias module:model/Project
     */
    constructor() { 
        
        Project.initialize(this);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj) { 
    }

    /**
     * Constructs a <code>Project</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/Project} obj Optional instance to populate.
     * @return {module:model/Project} The populated <code>Project</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new Project();

            if (data.hasOwnProperty('id')) {
                obj['id'] = ApiClient.convertToType(data['id'], 'Number');
            }
            if (data.hasOwnProperty('title')) {
                obj['title'] = ApiClient.convertToType(data['title'], 'String');
            }
            if (data.hasOwnProperty('dateStarted')) {
                obj['dateStarted'] = ApiClient.convertToType(data['dateStarted'], 'Date');
            }
            if (data.hasOwnProperty('dueDate')) {
                obj['dueDate'] = ApiClient.convertToType(data['dueDate'], 'Date');
            }
            if (data.hasOwnProperty('dateCompleted')) {
                obj['dateCompleted'] = ApiClient.convertToType(data['dateCompleted'], 'Date');
            }
            if (data.hasOwnProperty('goals')) {
                obj['goals'] = ApiClient.convertToType(data['goals'], ['String']);
            }
            if (data.hasOwnProperty('progress')) {
                obj['progress'] = ApiClient.convertToType(data['progress'], 'Number');
            }
            if (data.hasOwnProperty('status')) {
                obj['status'] = ProjectStatus.constructFromObject(data['status']);
            }
            if (data.hasOwnProperty('members')) {
                obj['members'] = ApiClient.convertToType(data['members'], [ProjectMember]);
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>Project</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>Project</code>.
     */
    static validateJSON(data) {
        // ensure the json data is a string
        if (data['title'] && !(typeof data['title'] === 'string' || data['title'] instanceof String)) {
            throw new Error("Expected the field `title` to be a primitive type in the JSON string but got " + data['title']);
        }
        // ensure the json data is an array
        if (!Array.isArray(data['goals'])) {
            throw new Error("Expected the field `goals` to be an array in the JSON data but got " + data['goals']);
        }
        if (data['members']) { // data not null
            // ensure the json data is an array
            if (!Array.isArray(data['members'])) {
                throw new Error("Expected the field `members` to be an array in the JSON data but got " + data['members']);
            }
            // validate the optional field `members` (array)
            for (const item of data['members']) {
                ProjectMember.validateJSON(item);
            };
        }

        return true;
    }


}



/**
 * @member {Number} id
 */
Project.prototype['id'] = undefined;

/**
 * @member {String} title
 */
Project.prototype['title'] = undefined;

/**
 * @member {Date} dateStarted
 */
Project.prototype['dateStarted'] = undefined;

/**
 * @member {Date} dueDate
 */
Project.prototype['dueDate'] = undefined;

/**
 * @member {Date} dateCompleted
 */
Project.prototype['dateCompleted'] = undefined;

/**
 * @member {Array.<String>} goals
 */
Project.prototype['goals'] = undefined;

/**
 * @member {Number} progress
 */
Project.prototype['progress'] = undefined;

/**
 * @member {module:model/ProjectStatus} status
 */
Project.prototype['status'] = undefined;

/**
 * @member {Array.<module:model/ProjectMember>} members
 */
Project.prototype['members'] = undefined;






export default Project;

