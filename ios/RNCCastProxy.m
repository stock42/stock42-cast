#import <RNGoogleCast/RNGoogleCast.h>
#import <React/RCTBridgeModule.h>

@interface RNCCastProxy : NSObject <RCTBridgeModule>
@end

@implementation RNCCastProxy
RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(startCast:(NSString *)url resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject) {
  [[RNGoogleCast sharedInstance] castMedia:url
                                   resolve:resolve
                                   reject:reject];
}

@end
