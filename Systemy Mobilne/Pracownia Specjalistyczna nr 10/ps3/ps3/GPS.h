//
//  GPS.h
//  ps3
//
//  Created by Janek on 09/12/2022.
//

#import <UIKit/UIKit.h>
#import <CoreLocation/CoreLocation.h>

NS_ASSUME_NONNULL_BEGIN

@interface GPS : UIViewController <CLLocationManagerDelegate>
{
    CLLocationManager *locationManager;
    CLGeocoder *geocoder;
    CLPlacemark *placemark;
}

@property(weak, nonatomic) IBOutlet UILabel *latitudeLabel;
@property(weak, nonatomic) IBOutlet UILabel *longtitudeLabel;
@property(weak, nonatomic) IBOutlet UILabel *addressLabel;

@property(weak, nonatomic) IBOutlet UITextField *latitudeText;
@property(weak, nonatomic) IBOutlet UITextField *longtitudeText;
@property(weak, nonatomic) IBOutlet UITextView *addressText;
@property(weak, nonatomic) IBOutlet UIButton *currentLocationButton;

-(IBAction)getCurrentLocationButton:(id)sender;

@end

NS_ASSUME_NONNULL_END
