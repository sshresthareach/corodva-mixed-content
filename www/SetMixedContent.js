var exec = require('cordova/exec');

exports.setMixedContentMode = function (mode, success, error) {
    if(isValidMode(mode)){
        exec(success, error, 'setMixedContentMode', 'setMixedContentMode', [mode.toLowerCase()]);
    } else {
        throw new Exception("Invalid mixed content mode. Valid modes are: 'always_allow', 'compatibility_mode', 'never_allow'");
    }
    
};

function isValidMode(mode){
    const modes = [
        'always_allow',
        'compatibility_mode',
        'never_allow'
    ];

    return modes.indexOf(mode.toLowerCase()) !== -1;
}
