<template>
  <div id="AddItem">
		<el-col :span="16" :offset="4">
			<el-card>
				<h2 id="item-title"> 新資産登録</h2>
				<el-form ref="itemForm" :model="itemForm">

					<el-row>
						<el-col :span="6">
							<el-form-item label="商品名前"></el-form-item>
						</el-col>
						<el-col :span="18">
							<el-input v-model="itemForm.devName"></el-input>
						</el-col>
					</el-row>

					<el-row>
						<el-col :span="6">
							<el-form-item label="カテゴリー"></el-form-item>
						</el-col>
						<el-col :span="18">
							<template>
								<el-select 
									v-model="itemForm.category"
									placeholder="カテゴリー選択してください"
									style="width: 100%;"
									@change="selectedCat(itemForm.category)">
								<el-option
								  v-for="cat in itemForm.categories"
								  :key="cat.value"
								  :label="cat.label"
								  :value="cat.value">
								</el-option>
							  </el-select>
							</template>
						</el-col>
					</el-row>

					<el-row>
						<el-col :span="6">
							<el-form-item label="ブランド"></el-form-item>
						</el-col>
						<el-col :span="18">
							<template>
								<el-select
								v-model="itemForm.brand"
								placeholder="ブランド選択してください"
								style="width: 100%;">
								<el-option
								  v-for="brd in itemForm.brands"
								  :key="brd.value"
								  :label="brd.label"
								  :value="brd.value">
								</el-option>
							  </el-select>
							</template>
						</el-col>
					</el-row>

					<el-row>
						<el-col :span="6">
							<el-form-item label="担当者"></el-form-item>
						</el-col>
						<el-col :span="18">
							<template>
								<el-select
									v-model="itemForm.pic"
									placeholder="担当者選択してください"
									style="width: 100%;">
								<el-option
								  v-for="emp in itemForm.employees"
								  :key="emp.name"
								  :label="emp.name"
								  :value="emp.id">
								</el-option>
							  </el-select>
							</template>
						</el-col>
					</el-row>

					<!-- Specifications for PC -->
					<div v-if="showPCSpec">
						<el-row style="text-align: center;">
							<el-tag type="primary"> Detailed Specifications
							</el-tag>
						</el-row>
						<el-row>
							<el-col :span="6">
								<el-form-item label="Model"></el-form-item>
							</el-col>
							<el-col :span="18">
								<el-input v-model="itemForm.model"></el-input>
							</el-col>
						</el-row>
						<el-row>
							<el-col :span="6">
								<el-form-item label="CPU Processor"></el-form-item>
							</el-col>
							<el-col :span="18">
								<el-input v-model="itemForm.cpu"></el-input>
							</el-col>
						</el-row>
						<el-row>
							<el-col :span="6">
								<el-form-item label="RAM"></el-form-item>
							</el-col>
							<el-col :span="18">
								<el-input v-model="itemForm.ram"></el-input>
							</el-col>
						</el-row>
						<el-row>
							<el-col :span="6">
								<el-form-item label="Storage HDD"></el-form-item>
							</el-col>
							<el-col :span="18">
								<el-input v-model="itemForm.storage"></el-input>
							</el-col>
						</el-row>
						<el-row>
							<el-col :span="6">
								<el-form-item label="Display Size"></el-form-item>
							</el-col>
							<el-col :span="18">
								<el-input v-model="itemForm.display"></el-input>
							</el-col>
						</el-row>
						<el-row>
							<el-col :span="6">
								<el-form-item label="Screen Resolution"></el-form-item>
							</el-col>
							<el-col :span="18">
								<el-input v-model="itemForm.resolution"></el-input>
							</el-col>
						</el-row>
						<el-row>
							<el-col :span="6">
								<el-form-item label="Graphic Card"></el-form-item>
							</el-col>
							<el-col :span="18">
								<el-input v-model="itemForm.graphic"></el-input>
							</el-col>
						</el-row>
						<el-row>
							<el-col :span="6">
								<el-form-item label="Battery"></el-form-item>
							</el-col>
							<el-col :span="18">
								<el-input v-model="itemForm.battery"></el-input>
							</el-col>
						</el-row>
						<el-row>
							<el-col :span="6">
								<el-form-item label="WiFi"></el-form-item>
							</el-col>
							<el-col :span="18">
								<el-input v-model="itemForm.wifi"></el-input>
							</el-col>
						</el-row>
						<el-row>
							<el-col :span="6">
								<el-form-item label="Windows Version"></el-form-item>
							</el-col>
							<el-col :span="18">
								<el-input v-model="itemForm.windows"></el-input>
							</el-col>
						</el-row>
						<el-row>
							<el-col :span="6">
								<el-form-item label="Touch Enable"></el-form-item>
							</el-col>
							<el-col :span="18">
								<template>
									<el-select
										v-model="itemForm.touch"
										placeholder="タッチ出来ますか？"
										style="width: 100%;">
										<el-option
										  v-for="tch in itemForm.touchs"
										  :key="tch.value"
										  :label="tch.label"
										  :value="tch.value">
										</el-option>
								  </el-select>
								</template>
							</el-col>
						</el-row>
					</div>

					<el-row id="text-center">
						<el-button type="primary" size="small">
							Register
						</el-button>
						<el-button type="danger" size="small" plain>
							Reset
						</el-button>
					</el-row>

					<!-- <el-row>
						<el-col :span="6">
							<el-form-item label="商品名前"></el-form-item>
						</el-col>
						<el-col :span="18">
							<el-input v-model="itemForm.devName"></el-input>
						</el-col>
					</el-row>

					<el-row>
						<el-col :span="6">
							<el-form-item label="商品名前"></el-form-item>
						</el-col>
						<el-col :span="18">
							<el-input v-model="itemForm.devName"></el-input>
						</el-col>
					</el-row>

					<el-row>
						<el-col :span="6">
							<el-form-item label="商品名前"></el-form-item>
						</el-col>
						<el-col :span="18">
							<el-input v-model="itemForm.devName"></el-input>
						</el-col>
					</el-row> -->

				</el-form>
			</el-card>
		</el-col>

	</div>
</template>

<script>
export default {
  name: 'AddItem',
	data: function() {
		return {
			itemForm: {
				devName: '',
				category: '',
				brand: '',
				pic: '',
				categories: [{
					value: 1,
					label: 'Laptop'
			  },{
					value: 2,
					label: 'Monitor'
			  },{
					value: 3,
					label: 'CPU'
			  },{
					value: 4,
					label: 'External Keyboard'
			  },{
					value: 5,
					label: 'Mouse'
				},{
					value: 6,
					label: 'Router'
				},{
					value: 7,
					label: 'Printer'
				},{
					value: 8,
					label: 'Projector'
				},{
					value: 9,
					label: 'Power Plug'
				},{
					value: 10,
					label: 'Table'
				},{
					value: 11,
					label: 'Chair'
				}],	
				brands: [{
					value: 1,
					label: 'Lenovo'
			  },{
					value: 2,
					label: 'HP'
			  },{
					value: 3,
					label: 'DELL'
			  },{
					value: 4,
					label: 'ASUS'
			  },{
					value: 5,
					label: 'Acer'
				},{
					value: 6,
					label: 'Apple'
				},{
					value: 7,
					label: 'EPSON'
				}],
				employees: [{
					id: 111,
					name: 'John',
			  },{
					id: 222,
					name: 'Morgan'
			  },{
					id: 333,
					name: 'Juno'
			  },{
					id: 444,
					name: 'Aurora'
			  },{
					id: 555,
					name: 'MoMo'
				},{
					id: 666,
					name: 'Standby'
				}],
				touchs: [{
					value: 0,
					label: 'No'
			  },{
					value: 1,
					label: 'Yes'
			  }],
				showPCSpec: false,
				showMoniSpec: false,
				showCPUSpec: false,
				showPrinterSpec: false,
				showProjSpec: false,
				showPlugSpec: false,
				showTableSpec: false,
				showChairSpec: false,
			},
		}
	},
	methods: {
		selectedCat(cat) {
			console.log("selectedCat:: " + cat)
			if( cat == 1 ) {
				this.showPCSpec = true
				this.showMoniSpec = false
				this.showCPUSpec = false
				this.showPrinterSpec = false
				this.showProjSpec = false
				this.showPlugSpec = false
				this.showTableSpeca = false
				this.showChairSpec = false
			} else if ( cat == 2) {
				this.showPCSpec = false
				this.showMoniSpec = true
				this.showCPUSpec = false
				this.showPrinterSpec = true
				this.showProjSpec = false
				this.showPlugSpec = false
				this.showTableSpeca = false
				this.showChairSpec = false
			} else if ( cat == 3) {
				this.showPCSpec = false
				this.showMoniSpec = false
				this.showCPUSpec = true
				this.showPrinterSpec = false
				this.showProjSpec = false
				this.showPlugSpec = false
				this.showTableSpeca = false
				this.showChairSpec = false
			} else if ( cat == 7) {
				this.showPCSpec = false
				this.showMoniSpec = false
				this.showCPUSpec = false
				this.showPrinterSpec = true
				this.showProjSpec = false
				this.showPlugSpec = false
				this.showTableSpeca = false
				this.showChairSpec = false
			} else if ( cat == 8) {
				this.showPCSpec = false
				this.showMoniSpec = false
				this.showCPUSpec = false
				this.showPrinterSpec = false
				this.showProjSpec = true
				this.showPlugSpec = false
				this.showTableSpeca = false
				this.showChairSpec = false
			} else if ( cat == 9) {
				this.showPCSpec = false
				this.showMoniSpec = false
				this.showCPUSpec = false
				this.showPrinterSpec = false
				this.showProjSpec = false
				this.showPlugSpec = true
				this.showTableSpeca = false
				this.showChairSpec = false
			} else if ( cat == 10) {
				this.showPCSpec = false
				this.showMoniSpec = false
				this.showCPUSpec = false
				this.showPrinterSpec = false
				this.showProjSpec = false
				this.showPlugSpec = false
				this.showTableSpeca = true
				this.showChairSpec = false
			} else if ( cat == 11) {
				this.showPCSpec = false
				this.showMoniSpec = false
				this.showCPUSpec = false
				this.showPrinterSpec = false
				this.showProjSpec = false
				this.showPlugSpec = false
				this.showTableSpeca = false
				this.showChairSpec = true
			} else {
				this.showPCSpec = false
				this.showMoniSpec = false
				this.showCPUSpec = false
				this.showPrinterSpec = false
				this.showProjSpec = false
				this.showPlugSpec = false
				this.showTableSpeca = false
				this.showChairSpec = false
			}
		}
	},
}
</script>

<style scoped>
	#gap-adjust {
		margin-bottom: 0px;
		margin-top: 20px;
	}
	#text-center {
		text-align: center;
	}
	#item-title {
		text-align: center;
		color: #2082e5;
	}
	el-card {
		margin-bottom: 200px!important;
	}
</style>


