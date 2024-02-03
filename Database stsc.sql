--
-- Database: `stsc`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `full_name` varchar(100) DEFAULT NULL,
  `image` varchar(500) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `id` int(11) NOT NULL,
  `appointment_id` int(50) NOT NULL,
  `customer_id` bigint(50) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `description` varchar(200) NOT NULL,
  `service` varchar(200) DEFAULT NULL,
  `supplies` varchar(200) DEFAULT NULL,
  `mobile_number` bigint(50) NOT NULL,
  `address` varchar(200) NOT NULL,
  `date` date NOT NULL,
  `date_modify` date DEFAULT NULL,
  `date_delete` date DEFAULT NULL,
  `status` varchar(50) NOT NULL,
  `employee` varchar(50) NOT NULL,
  `specialized` varchar(100) DEFAULT NULL,
  `schedule` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `customer_id` bigint(50) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `full_name` varchar(100) DEFAULT NULL,
  `mobile_number` bigint(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `image` varchar(500) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `service` varchar(200) DEFAULT NULL,
  `supplies` varchar(200) DEFAULT NULL,
  `employee` varchar(100) DEFAULT NULL,
  `specialized` varchar(100) DEFAULT NULL,
  `date` date NOT NULL,
  `date_modify` date DEFAULT NULL,
  `date_delete` date DEFAULT NULL,
  `status` varchar(100) NOT NULL,
  `status_pay` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `employee_id` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `full_name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `gender` varchar(100) DEFAULT NULL,
  `mobile_number` bigint(100) DEFAULT NULL,
  `specialized` varchar(100) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  `date` date NOT NULL,
  `modify_date` date DEFAULT NULL,
  `delete_date` date DEFAULT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `id` int(11) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `employee` varchar(250) DEFAULT NULL,
  `total_days` int(11) DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `date` date DEFAULT NULL,
  `date_checkout` date DEFAULT NULL,
  `date_pay` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Table structure for table `services`
--

CREATE TABLE `services` (
  `id` int(10) NOT NULL,
  `serviceID` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `unit` varchar(50) NOT NULL,
  `price` int(50) NOT NULL,
  `depict` varchar(200) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `services`
--

INSERT INTO `services` (`id`, `serviceID`, `name`, `unit`, `price`, `depict`, `status`) VALUES
(22, 'OC001', 'Oil Change', 'Car maintenance', 50, 'Regular oil change service', 'Active'),
(23, 'TR001', 'Tire Rotation', 'Car check', 30, 'Rotating tires for even wear', 'Active'),
(24, 'BI001', 'Brake Inspection', 'Check and maintain the car', 40, 'Inspection of brake system components', 'Active'),
(25, 'BR001', 'Battery Replacement', 'Car maintenance', 80, 'Replacement of car battery', 'Active'),
(26, 'AF001', 'Air Filter Replacement', 'Car check', 25, 'Replacing the air filter', 'Active'),
(27, 'WA001', 'Wheel Alignment', 'Check and maintain the car', 60, 'Aligning wheels for proper vehicle handling', 'Active'),
(28, 'SP001', 'Spark Plug Replacement', 'Car maintenance', 35, 'Replacing spark plugs for optimal engine performance', 'Active'),
(29, 'CF001', 'Coolant Flush', 'Car check', 45, 'Flushing and replacing coolant fluid', 'Active'),
(30, 'OC002', 'Oil Change', 'Car maintenance', 50, 'Regular oil change service', 'Active'),
(31, 'TR002', 'Tire Rotation', 'Car check', 30, 'Rotating tires for even wear', 'Active'),
(32, 'BI002', 'Brake Inspection', 'Check and maintain the car', 40, 'Inspection of brake system components', 'Active'),
(33, 'BR002', 'Battery Replacement', 'Car maintenance', 80, 'Replacement of car battery', 'Active'),
(34, 'AF002', 'Air Filter Replacement', 'Car check', 25, 'Replacing the air filter', 'Active'),
(35, 'WA002', 'Wheel Alignment', 'Check and maintain the car', 60, 'Aligning wheels for proper vehicle handling', 'Active'),
(36, 'SP002', 'Spark Plug Replacement', 'Car maintenance', 35, 'Replacing spark plugs for optimal engine performance', 'Active'),
(37, 'CF002', 'Coolant Flush', 'Car check', 45, 'Flushing and replacing coolant fluid', 'Active'),
(38, 'OC003', 'Oil Change', 'Car maintenance', 50, 'Regular oil change service', 'Active'),
(39, 'TR003', 'Tire Rotation', 'Car check', 30, 'Rotating tires for even wear', 'Active'),
(40, 'BI003', 'Brake Inspection', 'Check and maintain the car', 40, 'Inspection of brake system components', 'Active'),
(41, 'BR003', 'Battery Replacement', 'Car maintenance', 80, 'Replacement of car battery', 'Active'),
(42, 'AF003', 'Air Filter Replacement', 'Car check', 25, 'Replacing the air filter', 'Active'),
(43, 'WA003', 'Wheel Alignment', 'Check and maintain the car', 60, 'Aligning wheels for proper vehicle handling', 'Active'),
(44, 'SP003', 'Spark Plug Replacement', 'Car maintenance', 35, 'Replacing spark plugs for optimal engine performance', 'Active'),
(45, 'CF003', 'Coolant Flush', 'Car check', 45, 'Flushing and replacing coolant fluid', 'Active'),
(46, 'OC004', 'Oil Change', 'Car maintenance', 50, 'Regular oil change service', 'Active'),
(47, 'TR004', 'Tire Rotation', 'Car check', 30, 'Rotating tires for even wear', 'Active'),
(48, 'BI004', 'Brake Inspection', 'Check and maintain the car', 40, 'Inspection of brake system components', 'Active'),
(49, 'BR004', 'Battery Replacement', 'Car maintenance', 80, 'Replacement of car battery', 'Active'),
(50, 'AF004', 'Air Filter Replacement', 'Car check', 25, 'Replacing the air filter', 'Active'),
(51, 'RX001', 'Rửa xe', 'Bottle', 50000, 'Rửa', 'Inactive');

-- --------------------------------------------------------

--
-- Table structure for table `supplies`
--

CREATE TABLE `supplies` (
  `id` int(10) NOT NULL,
  `suppliesID` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `origin` varchar(50) NOT NULL,
  `productionYear` int(10) NOT NULL,
  `unit` varchar(50) NOT NULL,
  `price` varchar(50) NOT NULL,
  `quantity` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `supplies`
--

INSERT INTO `supplies` (`id`, `suppliesID`, `name`, `origin`, `productionYear`, `unit`, `price`, `quantity`, `status`) VALUES
(32, 'DMHD1', 'Engine Oil for Hyundai', 'Japan', 2021, 'Litre', '200000', '100', 'Active'),
(33, 'EABD1', 'Engine Air Filter', 'Germany', 2022, 'Piece', '150000', '50', 'Active'),
(34, 'TBMK1', 'Timing Belt Kit', 'South Korea', 2023, 'Piece', '300000', '30', 'Active'),
(35, 'RTPD1', 'Radiator and Thermostat', 'China', 2022, 'Set', '250000', '40', 'Active'),
(36, 'BSBR1', 'Brake Shoe and Brake Pads', 'USA', 2021, 'Set', '180000', '60', 'Active'),
(37, 'OFTF1', 'Oil Filter and Transmission Fluid', 'Japan', 2023, 'Set', '220000', '45', 'Active'),
(38, 'EPSG1', 'Engine Piston and Piston Rings', 'Germany', 2022, 'Set', '280000', '25', 'Active'),
(39, 'CSSP1', 'Clutch Set and Pressure Plate', 'South Korea', 2021, 'Set', '320000', '35', 'Active'),
(40, 'PSAB1', 'Power Steering Assembly and Belt', 'China', 2023, 'Set', '350000', '20', 'Active'),
(41, 'WSWF1', 'Wheel Studs and Wheel Flares', 'USA', 2022, 'Set', '180000', '55', 'Active'),
(42, 'FBAL1', 'Fuel Pump and Fuel Injector', 'Japan', 2021, 'Set', '300000', '40', 'Active'),
(43, 'TDTB1', 'Transmission Dipstick and Transmission Belt', 'Germany', 2023, 'Set', '250000', '30', 'Active'),
(44, 'RSAC1', 'Rear Suspension Arm and Coil', 'South Korea', 2022, 'Set', '280000', '25', 'Active'),
(45, 'ACAC1', 'Air Conditioning Assembly and Compressor', 'China', 2021, 'Set', '320000', '35', 'Active'),
(46, 'ESIF1', 'Engine Sensors and Ignition Fuse', 'USA', 2023, 'Set', '350000', '20', 'Active'),
(47, 'EMHS1', 'Engine Mounts and Head Gasket Set', 'Japan', 2022, 'Set', '180000', '55', 'Active'),
(48, 'EPG1', 'Engine Performance Gasket', 'Germany', 2021, 'Piece', '150000', '50', 'Active'),
(49, 'TBCH1', 'Timing Belt and Chain', 'South Korea', 2023, 'Set', '300000', '30', 'Active'),
(50, 'BLB1', 'Bearing and Lube', 'China', 2022, 'Set', '250000', '40', 'Active'),
(51, 'SPAS1', 'Spark Plugs and Alternator Set', 'USA', 2021, 'Set', '180000', '60', 'Active'),
(52, 'PSWB1', 'Power Steering Wheel and Belt', 'Japan', 2023, 'Set', '220000', '45', 'Active'),
(53, 'FTFI1', 'Fuel Tank and Fuel Injector', 'Germany', 2022, 'Set', '280000', '25', 'Active'),
(54, 'LSH1', 'Lubricant and Sealant Hose', 'South Korea', 2021, 'Piece', '320000', '35', 'Active'),
(55, 'STBS1', 'Suspension Tie Rod and Ball Joint Set', 'China', 2023, 'Set', '350000', '20', 'Active'),
(56, 'PSB1', 'Power Steering Belt', 'USA', 2022, 'Piece', '180000', '55', 'Active'),
(57, 'FBGB1', 'Fuel Bowl and Gasket Bolts', 'Japan', 2021, 'Set', '150000', '50', 'Active'),
(58, 'OFG1', 'Oil Filter Gasket', 'Germany', 2023, 'Piece', '300000', '30', 'Active'),
(59, 'ABP1', 'Alternator Brush and Pulley', 'South Korea', 2022, 'Set', '250000', '40', 'Active'),
(60, 'CSB1', 'Carburetor and Seal Bolts', 'China', 2021, 'Set', '180000', '60', 'Active'),
(61, 'ESC1', 'Engine Seal and Cover', 'USA', 2023, 'Piece', '220000', '45', 'Active'),
(62, 'DMVN', 'Dầu VN1', 'VN', 2024, 'Bottle', '100000', '1', 'Inactive'),
(63, 'DMHN1', 'Dầu máy Hồ Chí Minh', 'Việt Nam', 2024, 'Bottle', '250000', '50', 'Inactive');

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `services`
--
ALTER TABLE `services`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `supplies`
--
ALTER TABLE `supplies`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `appointment`
--
ALTER TABLE `appointment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `services`
--
ALTER TABLE `services`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT for table `supplies`
--
ALTER TABLE `supplies`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;
COMMIT;

