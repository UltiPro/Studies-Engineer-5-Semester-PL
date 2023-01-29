//
//  ViewController.h
//  ps3
//
//  Created by Janek on 09/12/2022.
//

#import <UIKit/UIKit.h>

@interface ViewController : UIViewController

@property(weak, nonatomic) IBOutlet UILabel *gestureLabel;

-(void)motionEnded:(UIEventSubtype)motion withEvent:(UIEvent *)event;
-(BOOL)canBecomeFirstResponder;
-(IBAction)showShakeDetectedAlert;

-(IBAction)tapGesture:(UITapGestureRecognizer *)sender;
-(IBAction)pinchGesture:(UIPinchGestureRecognizer *)sender;
-(IBAction)swipeGesture:(UISwipeGestureRecognizer *)sender;
-(IBAction)longPressGesture:(UILongPressGestureRecognizer *)sender;

@end

