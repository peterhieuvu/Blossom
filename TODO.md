# Early
* Put in system so that we can merge bind sets with duplicate types
* Rehaul input to use my input
	* There is a lot of function calling, so check to make sure everything in inlining
* System to load Settings
* Entity System
* Physics
* Debugging
* Logging
* Simple Profiler
* Tween Engine
* Map System
* Asset Management
* Screen Recording, Saving Compressed Video and stuff

# Current Features

## Graphics
* LibGDX backend
* GLES for all platforms

### 2d

### 3d

## Animation

## Logic

### Physics

### Entity

### Map

### Lifecycle

## Audio

## I/O
* Bind input system for Mouse and Keyboard done through LibGDX


# 2D

* Separate everything with an abstraction layer so we can separate from LibGDX any time
* Physics
	* Static, dynamic, kinematic (Scriptable) physics objects
	* Robust triggers
	* Native SIMB instruction so we can run from desktop to mobile
	* Collider shapes, collision detection routines,
	* Constraints (gear, hinge, point2point, slider, conetwist...),
	* rigidbodies, gravity control, integrate in the entity system.
	* Convex hull collision (rounded line segments)
* Binary Space Partitioning for rendering entities
* Quadtree for entity collisions Spatial hashes and binary space partitioning
* Tile clipping for rendering tiles
* Tile Map system for rendering maps and collisions with maps
* Non-tile based system for rendering maps without tiles
* Asset Management
* Particles
* Lighting
* AI, A* and stuff
* Logging system
* Fonts (TrueType using FreeType, Opentype, BMFont, Distance field fonts)
	* Static fonts (pregenerated at compile time
	* Dynamic font (computed at game time with a caching system)
	* Support use for font in your computer
* Automatic GUI layout and support for orientation changes
* GUI image nodes with slice-9 texturing
* GUI clipping/stencil masks
* Layered GUI with text, images and pie nodes
* Tile editor for 2D level geometry
* Curve editor to control particle parameter changes over the particle lifespan
* Particle effects editor with live preview of the emitter and modifier behavior
* Custom materials and shaders
	* Composition of modular shaders
		* Inheritance, shader mixins, automatic weaving of shader in-out attributes
		* Combine shaders into a full shader
		* Composition of shaders and effect permutations
		* No more need for large shaders with macros and #ifdef, instead you can reuse small shader units
	* Shader inheritance (multiple inheritance with mixins, define base intefaces or abstract class and reuse)
	* Combine multiple shaders based on defined parameters, automatic routing to appropriate generated shader
	* A shader can be a field/property of another shader to allow things from simple shader routing to complex aggregation scenarios
	* Effects are compiled when building a game at offline time so parameter permutations are generated from asset effect file
* Javadocs
* Debug Mode
* Networking
	* Peer to Peer and server client networking with reliable packet support
	* Proxies
* Shaders
* Look at performance tips for java, c++, android, ios, console, etc. and profile the game
* Pooling
* Entity framework
* Game Juice
* Anti-tunneling physics, and sweeping
* Profiler (Hierarchical)
* Check Minecraft code for ideas and stuff
* Level Streaming
* Level designer
* Visual Shader Editing
* Entity editor
* Particle editor
* Kinematic controller for collision without physics
* 3D models into 2D
* Vulkan support
* Dynamic batching in the render pipeline
* Asynchronous (or synchronous) loading of asset data
* Per platform configurable texture compression
* Pack sprites into atlases
* Static content dependencies for auto matic resource management. Only used assets are included
* Thread management
	* Distribute work across software and hardware threads
	* Schedule and monitor parallel computation at runtime
	* Thread priorities, stack size, affinity
* Statoscope (CRY) to show where performance is being spent
* Performance Comparison between profile runs or statoscopes
* Networking with kNet, possibility to make HTTP requests (URHO)
* Pathfinding and crowd simulation with Recast/Detour (URHO)
* Image loading with stb_image + DDS/KTX/PVR compressed texture support
* 2D and 3D audio playback. OGG Vorbis using stb_vorbis + WAV format support (URHO)
* Support for both 32-bit and 64-bit builds
* Build as one external library
* Unicode string support
* Scene rendering via entity based scene graph
	* Automatic management and rendering of scene entities
	* Frustum culling, light management, material application, dynamic cameras
* Inbuilt UI, localization, and database subsystems, internal file system
* Scene editor and UI layout editor with scripting
	* WPF model
	* Optimize for batching UI elements to graphics layer
	* Components
		* 9 patch style buttons
		* Borders, EditText, Image Button, ModalElement, Scrollbar,
		* ScrollingText, ScrollViewer, Slider, TextBlock, ToggleButton.
		* Checkbox, color picker, file dialog, scroll bar, text input, menu, window
		* Skinnable UI, light and dark defailt themes
		* Develop your own UI component
	* Layouts
		* Canvas, grid, panel, stackpanel, uniform grid
	* Events
		* RoutedEvents that you can easily bind to code
		* Direct Event directly on the control
		* Bubbling event going up to control hierarchy and can be canceled,
		* Tunneling Event going down the control hierarchy and can be cancelled
		* Input multiplexing to control how when events can happen
	* Rendering
		Customize rendering
		* Custom render factory for specific control that can run in pace of existing default renderer
	* Check out LIBGDX SCENE2D.ui
* Kotlin
* Adressable sotrage content (XENKO)
	* Minimize number of assets to recompile, track file versions and dependencies
	* Store assets on disk using plain files as database, packed into bundles (bundles support DLC)
	* Tagged assets to easily manage bundles
	* Ship game with minimum assets, then download extra later through bundles
	* Store Assets on disk as YAML files (easily authored in a text editor)
* Model/scene/animation/material import from formats supported by Open Asset Import Library (URHO)
* Support compiler toolchains: MSVC, GCC< Clang, MinGW, and cross-compiling derivatives
* Modules and Plugins
* Gesture recognition
* Virtual vuttons to abstract different input device events (like responding to both gamepad and keyboard event)
* ThinMatrix devlogs for optimization video about shifting queue and stuff
* Optimize
* Debug and test
	* Hot reload with custom Lua hooks for setup and inspection
	* Live on screen visual profiler
	* Remote web based profiler with visual frame sampling
	* Lua debugging with Zerobrane
	* Built in video capture of game footage
	* Native crash log APIs


# 3D

* Cache HLSL byte code if using Direct3D
* Look for performance tips
* Configurable rendering pipeline.
	* Defailt imlementations for forward, light pre-pass, and deferred rendering
* Component based scene model

* Ambient Occlusion
* Level Streaming
* Subsurface Scattering (Screen space)
* Iris parallax mapping for realistic eye representation.
* HDR Rendering
	* HDR Filmic tone mapping
		* Controlled HDR curve to mimic the behavior of filmic tone reproduction
* Physically Based Rendering material and lighting
* Motion blur
	* Object Based
	* Screen Based
* Real time local reflections (CRY: RLR)
	* Ray traced HDR reflections local to objects
* Depth of Field
* Realistic Vegetation (CRY: Grass and leaves and stuff)
* Lighting
	* IES lighting profiles
	* Point, spot, and directional lighting
	* Voxel Based Global Illumination (CRY: SVOGI, extends IBL)
		* Large Scale ambient occlusion
		* Real time indirect light bounce
		* Eliminate pre-baking to save disk space and make dynamic lighting throughout the day
	* Image Based Lighting (IBL)
	* Screen space directional occlusion (CRY: SSDO)
		* Enhanced version of Screen Space Ambient Occlusion
		* Any number of lights can be included in calculation of Ambient Occlusion, color of all lights taken into account
	* Image based lighting (CRY: IBL)
		* Bidirectional reflectance distribution function values
		* Normalization of specular highlights
		* Hard specular reflections = single texture lookup
		* Blurry reflections approximated by adjusting mipmap level during lookup
* Per Object Shadow Maps (CRY)
	* Custom shadow maps per entity (higher quality because higher world space shadow texel density and reduced depth range)
	* Shadow mapping for all light tipes
		* Cascaded shadow maps for directional lights
		* Normal offset adjustment and addition to depth bias
* Geomipmapped terrain
* Static and skinned decals
* Auxiliary view rendering (reflections etc.)
* General post processing
* 2D sprites and particles integrating into 3D scene
* Task based multithreading (engine worker thread pool)
* Bloom
* Particle system
	* Offload particle management and proccessing to GPU
* Volumetric fog shadows
* Import models from 3DS Max, Maya, Blender, maybe more
* Skeleton deforms and blend shapes
* Multiple light types and shadow mapping
	* Simulate candle light, sun light, flashlights, global lights
	* PSSM, SSAO
	* Baked Shadows
* Efficient Anti-ailiasing
	* Temporal
	* Preprocessing roughness maps to minimize specular aliasing
	* Screen space normal variance filter for flickering highlights on thin geometry
	* Super sampling
* Linear color modes
* Post process fog, glow, bloom, color adjustment
* Real time dynamic water caustics
* Hardware accelerated tesselation on meshes and animated characters (tesselation and displacement)
	* Phong
	* PN Triangles
	* Displacement Mapping
* Lense flare (Composite 3D lens flares)
* Multi-layer navigation mesh (CRY: NMN)
	* Dynamic navigation data structure
	* Real time dynamic updates in game
* Advanced AI
	* Modular sensory systems like hearing and sight
	* Locomotion systems
* Automatic instancing on SM3 capable hardware(URHO)
* Scene and object load/save in binary, XML, and JSON
* Background resource loading
* Merge meshes (XENKO: model batching) to optimize content for mobile
	* Pluggable rednering for forward or deferred rendering, with or without shadow maps


# Animation Tool
* Visual editor with timeline
* Full blending support
* Frame-based, cutout, and bone animations for sprites and rigs
* Animate any property of an object, even function calls
* Custom transition curves, tweens, interpolation
* Animation helper
* Optimizer to pack animations, 2d and 3d with delta compression
* Animation tree for fluid character animations
* Procedural motion warping algorithms (Dynamically scriptable Inverse Kinematics)
	* CC D-IK
	* Analytic IK
	* Example based IK
	* Physical simulations
* Animate all sprite and GUI properties
* Parametric skeletal animation, blending
* Geometry cache
	* Store and play back simulated geometry with point caching techniques
	* Compress to save from the huge size
	* Instancing support
	* Streaming and buffered playback
* Physicalized character customization
	* Physics based simulated attachments to add more dynamics and details
	* Attatch ropes, cloths, and rigid accessories
* Hardware skinning, vertex morph, node animation
* Keyframe animation of object attributes
* Flip book animations for sprites, GUI nodes, and particles

	
# Audio
* Events, Switches, States, RTPCs, granular management of pre loading soundbanks
* Real time updating editor without required restart
* Hierarchichy of mixers, fully scriptable
* Hardware decompressors on mobile
* Audio System handles buffering and pooling of sounds
* Control panning, volume, etc.
* Dynamic audio with virtual instruments
* Audio generation