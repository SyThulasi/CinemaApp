import DataHandler from "./DataHandler";
import { Component } from "react";
import { useSelector } from "react-redux";


export class APIHandler extends Component{
    

    static getHeaderNoToken(api_name) {

        return {'Content-Type': 'application/json'};
    }
    static getHeaderWithPasswordAuth() {

        return {
          "Content-Type": "application/json",
          Authorization: `Basic ${btoa(
            `${DataHandler.getFromSession(
              "username"
            )}:${DataHandler.getFromSession("password")}`
          )}`,
        };
    }

}