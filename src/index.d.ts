import { NativeEventEmitter } from "react-native";

export function startCast(url: string): Promise<void>;
export function stopCast(): Promise<void>;

/** Eventos emitidos por el módulo nativo (SESSION_STARTED, etc.) */
export const events: NativeEventEmitter;

export function CastButton(props: any): JSX.Element;
export function useCastState():
  | "NO_DEVICES_AVAILABLE"
  | "NOT_CONNECTED"
  | "CONNECTING"
  | "CONNECTED";
