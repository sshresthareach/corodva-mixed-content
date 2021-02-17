// Type definitions for cordova.plugins.content

/// <reference types="cordova" />

interface Content {
    setMixedContentMode: (
        mode: string,
        successCallback: (status: string) => void,
        errorCallback: (error: string) => void
    ) => void;
}

interface CordovaPlugins {
    content: Content;
}
