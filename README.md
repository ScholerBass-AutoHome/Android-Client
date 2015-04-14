# Android-Client
The Android client for the AutoHome box.

## Synopsis
This app will act as a controller for the AutoHome box (still awaiting a name...), and will interact directly over Wi-Fi or indirectly through a domain (still awaiting one of those too...) with the [Pi Server](https://github.com/ScholerBass-AutoHome/Pi-Server), written by [Andrew Bass](https://github.com/andbass) in Rust. 

## How they interact
This app and the [Pi Server](https://github.com/ScholerBass-AutoHome/Pi-Server) will interact via an array of HTTP requests. These are all either POST or GET, at least for now. The URL will look similar to this: http://\<unit serial number\>.local/\<function\>.

## Functionality
Although I do not have anything working yet, and am still working through UI/UX mainly, the functionality I hope to have in v1 is as follows:
* Basic outlet control
* Appliance scheduling
* Adding/deleting/editing of appliances (aliases for outlets)
* Adding units

By v2 of the app, I hope to have NFC tags working (tap to toggle). If you have anything you would like to see, please shoot me a message on here, or an email: benscholer3248511@gmail.com
