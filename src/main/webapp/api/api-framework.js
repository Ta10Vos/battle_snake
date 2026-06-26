export default class ApiFramework {
    apiRoute = "restservices/";

    constructor(apiRoute = null) {
        this.apiRoute = apiRoute ?? this.apiRoute;
    }

    async getRequest(endpoint, params = {}) {
        const options = {
            method: "GET",
            headers: {"content-type": "application/json"},
            ...params
        };
        const response = await fetch(this.apiRoute + endpoint, options);

        if (!response.status.toString().startsWith("4") && !response.status.toString().startsWith("5")) {
            if (!response) {
                return true;
            }
            return await response.json();
        } else {
            const message = response.message ?? "Something went wrong";
            alert("Error: " + message);
            return false;
        }
    }

    async putRequest(endpoint, params) {
        const options = {
            method: "PUT",
            headers: {"content-type": "application/json"},
            ...params
        };
        const response = await fetch(this.apiRoute + endpoint, options);

        if (!response.status.toString().startsWith("4") && !response.status.toString().startsWith("5")) {
            if (!response) {
                return true;
            } else {
                return await response.json();
            }
        } else {
            const message = response.message ?? "Something went wrong";
            alert("Error: " + message);
            return false;
        }
    }
}