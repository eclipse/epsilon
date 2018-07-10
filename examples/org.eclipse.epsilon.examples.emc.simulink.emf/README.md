Acknowledgments:
 - The metamodel file (metamodel/simulink.ecore) was taken the Massif project (from https://github.com/viatra/massif) 
 - The models found under the model/emf/ directory were generated with the Massif project import facilities using the shallow approach. 
 - The models found under the model/native/ directory were taken from the aerospace directory of MATLAB ($MATLAB_ROOT/toolbox/simulink/simdemos/aerospace/). It is preferred to point at the original location of the files rather than the ones provided in this project as they might require references to external models only found in their original MATLAB directory. If using the original location, update the working directory accordingly. 
 - The native Simulink models were created for MATLAB 2018a version. To run the validation scripts it might be needed to have installed the MATLAB version 2018a.

Instructions:
 - Before you run the run configurations make sure you have installed the latest *interim* version of the  Epsilon Project and that you have provided in the Epsilon/Simulink eclipse preferences the path of the MATLAB Engine Jar and MATLAB Library.
 - To run the native validation script (management/validation/nativeValidation.evl) use the example run configuration provided in run/nativeValidation.launch
 - To run the EMF validation script (management/validation/emfValidation.evl) use the example run configuration provided in run/emfValidation.launch
 
Both example eclipse run configurations have been provided to run with the Simulink model "f14c" found under the aerospace library of MATLAB/Simulink or in the exported EMF version in the directory model/emf/ of this project. The model can be changed by modifying the model file of the model dialog in both run configurations.  