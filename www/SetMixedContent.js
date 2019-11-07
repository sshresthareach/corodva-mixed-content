var exec = require('cordova/exec');

/**
 * Manages Mixed Content Mode
 * @class MixedContentMode
 */
var MixedContentMode = function() {
}

/**
 * sets mixed content mode
 * @param {string} mode
 * @param {function} success - callback function
 * @param {function} error - callback function
 */
MixedContentMode.prototype.setMixedContentMode = function (mode, success, error) {
    if(this.isValidMode(mode)){
        exec(success, error, 'SetMixedContent', 'setMixedContentMode', [mode.toLowerCase()]);
    } else {
        throw new Error("Invalid mixed content mode. Valid modes are: 'always_allow', 'compatibility_mode', 'never_allow'");
    }
    
};

/**
 * Checks if the mode is valid
 * @params {string} mode
 */
MixedContentMode.prototype.isValidMode = function (mode){
    const modes = [
        'always_allow',
        'compatibility_mode',
        'never_allow'
    ];

    return modes.indexOf(mode.toLowerCase()) !== -1;
}

var mode = new MixedContentMode();

module.exports = mode;
