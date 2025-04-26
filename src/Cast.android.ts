// src/Cast.android.ts
import { NativeModules, NativeEventEmitter } from "react-native";

console.info("NativeModules: ", NativeModules);
const { MyCastModule } = NativeModules;
export const startCast = MyCastModule.startCast;
export const stopCast = MyCastModule.stopCast;
export const events = new NativeEventEmitter(MyCastModule);
